package com.github.dweindl.intellijAntimony.services

import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.github.dweindl.intellijAntimony.AntimonyBundle
import com.github.dweindl.intellijAntimony.AntimonyLanguage
import com.github.dweindl.intellijAntimony.AntimonyToSbmlAction.getPythonInterpreterPath
import com.github.dweindl.intellijAntimony.AntimonyToSbmlAction.isAntimonyAvailable
import com.github.dweindl.intellijAntimony.AntimonyToSbmlAction.getPyCodeSbmlToAnt
import com.github.dweindl.intellijAntimony.AntimonyToSbmlAction.createAndOpenScratchFile
import com.intellij.execution.ExecutionException
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.util.ExecUtil
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.fileChooser.FileChooserFactory

@Service(Service.Level.PROJECT)
class AntimonyProjectService(private val project: Project) {

    init {
        thisLogger().info(AntimonyBundle.message("projectService", project.name))
    }

    fun sbmlToAntimony() {
        val interpreter = getPythonInterpreterPath(project)
        if (interpreter == null) {
            // TODO: somehow open the project settings?
            Messages.showErrorDialog(project, "No Python interpreter found", "Error")
            return
        }

        val logger = Logger.getInstance(AntimonyProjectService::class.java)
        logger.info("Python interpreter: $interpreter")


        // show file selection dialog
        val descriptor = FileChooserDescriptor(true, false, false, false, false, false)
        descriptor.title = "Select SBML File"
        descriptor.description = "Please select an SBML file"
        descriptor.withFileFilter { it.extension == "xml" }

        val chooser = FileChooserFactory.getInstance().createFileChooser(descriptor, project, null)
        val files = chooser.choose(project)

        if (files.isEmpty()) {
            return
        }
        val file = files.first()

        ApplicationManager.getApplication().executeOnPooledThread {
            if (!isAntimonyAvailable(project)) {
                return@executeOnPooledThread
            }

            val commandLine = GeneralCommandLine()
            commandLine.exePath = interpreter
            val pythonCode = getPyCodeSbmlToAnt(file!!.path)
            commandLine.addParameter("-c")
            commandLine.addParameter(pythonCode)

            try {
                val output = ExecUtil.execAndGetOutput(commandLine)
                val exitCode = output.exitCode
                if (exitCode != 0) {
                    logger.info("Command: ${commandLine.commandLineString}")
                    ApplicationManager.getApplication().invokeLater {
                        Messages.showErrorDialog(project, output.stderr, "Antimony Error")
                    }
                    return@executeOnPooledThread
                }
                ApplicationManager.getApplication().invokeLater {
                    createAndOpenScratchFile(project, "$file converted to Antimony.ant", output.stdout, AntimonyLanguage.INSTANCE)
                }
            } catch (ex: ExecutionException) {
                throw RuntimeException(ex)
            }
        }
    }
}
