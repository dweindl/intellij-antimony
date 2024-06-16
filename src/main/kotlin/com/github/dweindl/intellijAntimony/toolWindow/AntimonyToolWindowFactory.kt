package com.github.dweindl.intellijAntimony.toolWindow

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.github.dweindl.intellijAntimony.AntimonyBundle
import com.github.dweindl.intellijAntimony.services.AntimonyProjectService
import javax.swing.JButton


class AntimonyToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val myToolWindow = AntimonyToolWindow(toolWindow)
        val content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    class AntimonyToolWindow(toolWindow: ToolWindow) {

        private val service = toolWindow.project.service<AntimonyProjectService>()

        fun getContent() = JBPanel<JBPanel<*>>().apply {
            add(JButton(AntimonyBundle.message("sbmlToAntimony")).apply {
                addActionListener {
                    service.sbmlToAntimony()
                }
            })
        }
    }
}
