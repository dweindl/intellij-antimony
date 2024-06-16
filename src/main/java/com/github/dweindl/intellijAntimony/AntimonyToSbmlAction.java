package com.github.dweindl.intellijAntimony;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.process.ProcessOutput;
import com.intellij.execution.util.ExecUtil;
import com.intellij.ide.scratch.ScratchRootType;
import com.intellij.lang.Language;
import com.intellij.lang.xml.XMLLanguage;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;
import com.github.dweindl.intellijAntimony.psi.AntimonyFile;
import com.jetbrains.python.sdk.PythonSdkType;
import com.intellij.openapi.ui.Messages;
import com.intellij.execution.configurations.GeneralCommandLine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class AntimonyToSbmlAction extends AnAction implements DumbAware {
    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String interpreter = getPythonInterpreterPath(e.getProject());
        if (interpreter == null) {
            // TODO: somehow open the project settings?
            Messages.showErrorDialog(e.getProject(), "No Python interpreter found", "Error");
            return;
        }

        Logger LOG = Logger.getInstance(AntimonyToSbmlAction.class);
        LOG.info("Python interpreter: " + interpreter);

        ApplicationManager.getApplication().executeOnPooledThread(() -> {
            if (!isAntimonyAvailable(e.getProject())) {
                return;
            }

            GeneralCommandLine commandLine = new GeneralCommandLine();
            commandLine.setExePath(interpreter);
            VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
            if (virtualFile == null) {
                return;
            }
            String filePath = virtualFile.getPath();
            String pythonCode = getPyCodeAntToSbml(filePath);
            commandLine.addParameter("-c");
            commandLine.addParameter(pythonCode);

            try {
                ProcessOutput output = ExecUtil.execAndGetOutput(commandLine);
                int exitCode = output.getExitCode();
                if (exitCode != 0) {
                    LOG.info("Command: " + commandLine.getCommandLineString());
                    ApplicationManager.getApplication().invokeLater(
                            () -> Messages.showErrorDialog(e.getProject(), output.getStderr(), "Antimony Error")
                    );
                    return;
                }
                ApplicationManager.getApplication().invokeLater(
                        () -> createAndOpenScratchFile(e.getProject(), filePath + " converted to SBML.xml", output.getStdout(), XMLLanguage.INSTANCE)
                );
            } catch (ExecutionException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private static @NotNull String getPyCodeAntToSbml(String file) {
        String pycode = """
        import antimony as ant
        import sys
        
        def error(msg):
            print(msg, file=sys.stderr)
            sys.exit(1)
        
        status = ant.loadAntimonyFile('FILE')
        
        if status < 0:
            error(f'Antimony model could not be loaded:\\n{ant.getLastError()}')
        
        if (main_module_name := ant.getMainModuleName()) is None:
            error('There is no Antimony module.')
        
        sbml_str = ant.getSBMLString(main_module_name)
        if not sbml_str:
            error('Antimony model could not be converted to SBML.')
        
        print(sbml_str)
        """;
        pycode = pycode.replace("FILE", file);
        return pycode;
    }

    public static @NotNull String getPyCodeSbmlToAnt(String file) {
        String pycode = """
        import antimony as ant
        import sys
        
        def error(msg):
            print(msg, file=sys.stderr)
            sys.exit(1)
        
        status = ant.loadSBMLFile('FILE')
        
        if status < 0:
            error(f'SBML model could not be loaded:\\n{ant.getLastError()}')
        
        
        ant_str = ant.getAntimonyString()
        if not ant_str:
            error('SBML model could not be converted to SBML: \\n{ant.getLastError()}')
        
        print(ant_str)
        """;
        pycode = pycode.replace("FILE", file);
        return pycode;
    }

    @Override
    public void update(AnActionEvent e) {
        // define when the action should be visible
        boolean visible = false;
        Project project = e.getProject();
        if (project != null) {
            Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
            if (editor != null) {
                PsiFile psiFile = PsiUtilBase.getPsiFileInEditor(editor, project);
                visible = psiFile instanceof AntimonyFile;
            }
        }

        e.getPresentation().setEnabledAndVisible(visible);
    }

    public static boolean isAntimonyAvailable(Project project) {
        String interpreter = getPythonInterpreterPath(project);
        if (interpreter == null) {
            return false;
        }

        GeneralCommandLine commandLine = new GeneralCommandLine();
        commandLine.setExePath(interpreter);
        commandLine.addParameter("-c");
        commandLine.addParameter("'import antimony'");

        try {
            ProcessOutput output = ExecUtil.execAndGetOutput(commandLine);
            int exitCode = output.getExitCode();
            if (exitCode != 0) {
                String installCmd = interpreter + "-m pip install antimony";
                ApplicationManager.getApplication().invokeLater(
                        () -> Messages.showErrorDialog(project,
                        "Antimony is not available in the Python environment, consider running `"
                        + installCmd + "`\n" + output.getStderr(), "Antimony Error"
                ));
            }
            return exitCode == 0;
        } catch (ExecutionException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String getPythonInterpreterPath(Project project) {
        Sdk sdk = ProjectRootManager.getInstance(project).getProjectSdk();

        // Check if the SDK is a Python SDK
        if (sdk != null && sdk.getSdkType() instanceof PythonSdkType) {
            // Get the home path of the Python interpreter
            return sdk.getHomePath();
        }

        return null;
    }

    public static void createAndOpenScratchFile(Project project, String fileName, String fileContent, @Nullable Language language) {
        VirtualFile scratchFile = ScratchRootType.getInstance().createScratchFile(
                project,
                fileName,
                language,
                fileContent
        );

        if (scratchFile != null) {
            Document document = FileDocumentManager.getInstance().getDocument(scratchFile);
            if (document != null) {
                FileEditorManager.getInstance(project).openFile(scratchFile, true);
            }
        }
    }
}