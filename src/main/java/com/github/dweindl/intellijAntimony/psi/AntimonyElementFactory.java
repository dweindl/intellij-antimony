package com.github.dweindl.intellijAntimony.psi;


import com.github.dweindl.intellijAntimony.AntimonyFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;

public class AntimonyElementFactory {

    public static AntimonyIdentifier createIdentifier(Project project, String name) {
        final AntimonyFile file = createFile(project, name + " = 0;");
        return PsiTreeUtil.findChildOfType(file, AntimonyIdentifier.class);
    }

    public static AntimonyFile createFile(Project project, String text) {
        String name = "dummy.ant";
        return (AntimonyFile) PsiFileFactory.getInstance(project).createFileFromText(name, AntimonyFileType.INSTANCE, text);
    }

}