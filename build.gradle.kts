import org.jetbrains.changelog.Changelog
import org.jetbrains.changelog.markdownToHTML
import org.jetbrains.intellij.platform.gradle.TestFrameworkType
import org.jetbrains.intellij.platform.gradle.tasks.GenerateLexerTask
import org.jetbrains.intellij.platform.gradle.tasks.GenerateParserTask
import org.jetbrains.intellij.platform.gradle.tasks.VerifyPluginTask

plugins {
    id("java") // Java support
    alias(libs.plugins.kotlin) // Kotlin support
    alias(libs.plugins.intelliJPlatform) // IntelliJ Platform Gradle Plugin
    alias(libs.plugins.grammarKit) // Grammar-Kit/JFlex parser & lexer generation
    alias(libs.plugins.changelog) // Gradle Changelog Plugin
    alias(libs.plugins.qodana) // Gradle Qodana Plugin
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

// Set the JVM language level used to build the project.
kotlin {
    jvmToolchain(21)
}

// Include the generated files in the source set
sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}

// Configure project's dependencies
repositories {
    mavenCentral()

    // IntelliJ Platform Gradle Plugin Repositories Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-repositories-extension.html
    intellijPlatform {
        defaultRepositories()
    }
}

// Dependencies are managed with Gradle version catalog - read more: https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog
dependencies {
    testImplementation(libs.junit)
    // testImplementation(libs.opentest4j)

    // IntelliJ Platform Gradle Plugin Dependencies Extension - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-dependencies-extension.html
    intellijPlatform {
        create(providers.gradleProperty("platformType"), providers.gradleProperty("platformVersion"))

        // Plugin Dependencies. Uses `platformBundledPlugins` property from the gradle.properties file for bundled IntelliJ Platform plugins.
        bundledPlugins(providers.gradleProperty("platformBundledPlugins").map { it.split(',') })

        // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file for plugin from JetBrains Marketplace.
        plugins(providers.gradleProperty("platformPlugins").map { it.split(',') })

        testFramework(TestFrameworkType.Platform)
    }
}

// Configure IntelliJ Platform Gradle Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin-extension.html
intellijPlatform {
    pluginConfiguration {
        name = providers.gradleProperty("pluginName")
        version = providers.gradleProperty("pluginVersion")

        // Extract the <!-- Plugin description --> section from README.md and provide for the plugin's manifest
        description = providers.fileContents(layout.projectDirectory.file("README.md")).asText.map {
            val start = "<!-- Plugin description -->"
            val end = "<!-- Plugin description end -->"

            with(it.lines()) {
                if (!containsAll(listOf(start, end))) {
                    throw GradleException("Plugin description section not found in README.md:\n$start ... $end")
                }
                subList(indexOf(start) + 1, indexOf(end)).joinToString("\n").let(::markdownToHTML)
            }
        }

        val changelog = project.changelog // local variable for configuration cache compatibility
        // Get the latest available change notes from the changelog file
        changeNotes = providers.gradleProperty("pluginVersion").map { pluginVersion ->
            with(changelog) {
                renderItem(
                    (getOrNull(pluginVersion) ?: getUnreleased())
                        .withHeader(false)
                        .withEmptySections(false),
                    Changelog.OutputType.HTML,
                )
            }
        }

        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
            // A blank pluginUntilBuild in gradle.properties means "no upper bound", so the plugin
            // keeps working with future IDE releases without needing a re-release.
            untilBuild = providers.gradleProperty("pluginUntilBuild").flatMap {
                if (it.isBlank()) provider { null } else providers.gradleProperty("pluginUntilBuild")
            }
        }
    }

    signing {
        certificateChain = providers.environmentVariable("CERTIFICATE_CHAIN")
        privateKey = providers.environmentVariable("PRIVATE_KEY")
        password = providers.environmentVariable("PRIVATE_KEY_PASSWORD")
    }

    publishing {
        token = providers.environmentVariable("PUBLISH_TOKEN")
        // The pluginVersion is based on the SemVer (https://semver.org) and supports pre-release labels, like 2.1.7-alpha.3
        // Specify pre-release label to publish the plugin in a custom Release Channel automatically. Read more:
        // https://plugins.jetbrains.com/docs/intellij/deployment.html#specifying-a-release-channel
        channels = providers.gradleProperty("pluginVersion").map { listOf(it.substringAfter('-', "").substringBefore('.').ifEmpty { "default" }) }
    }

    pluginVerification {
        // Drop INTERNAL_API_USAGES from the default failureLevel (COMPATIBILITY_PROBLEMS,
        // INTERNAL_API_USAGES, OVERRIDE_ONLY_API_USAGES). AntimonyToolWindowFactory implements
        // ToolWindowFactory without overriding its internal-marked default methods (manage,
        // getAnchor, getIcon); Kotlin's default-methods compilation still generates bridge
        // overrides for them, which the verifier flags as internal-API usage even though nothing
        // in our code calls them. The verifier itself still reports the plugin as Compatible.
        failureLevel = listOf(VerifyPluginTask.FailureLevel.COMPATIBILITY_PROBLEMS, VerifyPluginTask.FailureLevel.OVERRIDE_ONLY_API_USAGES)

        ides {
            // Not recommended(): its default IDE-selection range is derived from this plugin's declared
            // ideaVersion.untilBuild, which is intentionally left unbounded. Bound the verifier's own
            // range explicitly via pluginVerifierUntilBuild instead, so it only targets already-resolvable
            // IDE builds.
            select {
                untilBuild = providers.gradleProperty("pluginVerifierUntilBuild")
            }
        }
    }
}

// Configure Gradle Changelog Plugin - read more: https://github.com/JetBrains/gradle-changelog-plugin
changelog {
    groups.empty()
    repositoryUrl = providers.gradleProperty("pluginRepositoryUrl")
}

tasks {
    wrapper {
        gradleVersion = providers.gradleProperty("gradleVersion").get()
    }

    publishPlugin {
        dependsOn(patchChangelog)
    }

    // Regenerate the lexer/parser/PSI classes checked into src/main/gen after editing
    // Antimony.bnf / _AntimonyLexer.flex. Run `./gradlew generateLexer generateParser`,
    // review the diff, then commit the regenerated output alongside the grammar change.
    named<GenerateLexerTask>("generateLexer") {
        sourceFile = file("src/main/java/com/github/dweindl/intellijAntimony/_AntimonyLexer.flex")
        targetRootOutputDir = file("src/main/gen")
        packageName = "com.github.dweindl.intellijAntimony"
        pathToClass = "com/github/dweindl/intellijAntimony/_AntimonyLexer.java"
        purgeOldFiles = true
    }

    named<GenerateParserTask>("generateParser") {
        // Needs the project's own compiled classes on the classpath so the generator can detect
        // the psiImplUtilClass mixin method signatures (e.g. AntimonyPsiImplUtil.getName(...));
        // otherwise it silently skips declaring them on the generated PSI interfaces. Deliberately
        // NOT sourceSets.main.output: that FileCollection carries an implicit build dependency on
        // compileJava/compileKotlin, which read src/main/gen as a source dir that this task also
        // writes to - Gradle rejects that as a cyclic implicit dependency. Plain paths avoid it.
        // Run `./gradlew compileJava` (or a full build) at least once first.
        mustRunAfter(":compileJava")
        classpath += files("build/classes/java/main", "build/classes/kotlin/main")
        sourceFile = file("src/main/java/com/github/dweindl/intellijAntimony/Antimony.bnf")
        targetRootOutputDir = file("src/main/gen")
        pathToParser = "com/github/dweindl/intellijAntimony/parser/AntimonyParser.java"
        pathToPsiRoot = "com/github/dweindl/intellijAntimony/psi"
        purgeOldFiles = true
    }
}

intellijPlatformTesting {
    runIde {
        register("runIdeForUiTests") {
            task {
                jvmArgumentProviders += CommandLineArgumentProvider {
                    listOf(
                        "-Drobot-server.port=8082",
                        "-Dide.mac.message.dialogs.as.sheets=false",
                        "-Djb.privacy.policy.text=<!--999.999-->",
                        "-Djb.consents.confirmation.enabled=false",
                    )
                }
            }

            plugins {
                robotServerPlugin()
            }
        }
    }
}