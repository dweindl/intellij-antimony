package com.github.dweindl.intellijantimony.psi;


import com.github.dweindl.intellijantimony.AntimonyFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;

public class AntimonyElementFactory {

    public static AntimonyIdentifier createIdentifier(Project project, String name) {
        final AntimonyFile file = createFile(project, name + " = 0");
        return (AntimonyIdentifier) file.getFirstChild().getFirstChild().getFirstChild().getFirstChild();
    }

    public static AntimonyFile createFile(Project project, String text) {
        String name = "dummy.ant";
        return (AntimonyFile) PsiFileFactory.getInstance(project).createFileFromText(name, AntimonyFileType.INSTANCE, text);
    }
/*
    public static AntimonyProperty createProperty(Project project, String name, String value) {
        final AntimonyFile file = createFile(project, name + " = " + value);
        return (AntimonyProperty) file.getFirstChild();
    }
*/
    public static PsiElement createCRLF(Project project) {
        final AntimonyFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

}