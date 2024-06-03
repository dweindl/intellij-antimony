# intellij-antimony

![Build](https://github.com/dweindl/intellij-antimony/workflows/Build/badge.svg)
<!--
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
-->

<!-- Plugin description -->
This IntelliJ Platform plugin provides basic support for the
[Antimony](https://doi.org/10.1093/bioinformatics/btp401)
[language](https://tellurium.readthedocs.io/en/latest/antimony.html).

Files with the `.ant` extension will be recognized as Antimony files.

**Features**:

* Syntax highlighting
* Rename refactoring
* Find usages
* Go to declaration
* (very basic) code completion
* (very basic) structure view
<!-- Plugin description end -->


*Development is in a very early stage, so expect bugs and missing features.
Code quality is also not great yet. This is my first IntelliJ plugin, so I'm still learning.
Grammar is still incomplete, so some Antimony files may not be parsed correctly.
Everything is subject to change. Contributions are welcome.*


<!--
## Template ToDo list

- [ ] Get familiar with the [template documentation][template].
- [ ] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
--> 

## Installation
<!--
- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "intellij-antimony"</kbd> >
  <kbd>Install</kbd>
-->

- Manually:

  Download the [latest release](https://github.com/dweindl/intellij-antimony/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template] which was released under the
[Apache-2.0 license](https://github.com/JetBrains/intellij-platform-plugin-template/blob/81206eb0c2c9af1336750a13e471155b4fd2bea8/LICENSE).

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
