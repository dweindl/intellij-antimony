package com.github.dweindl.intellijantimony.psi.impl;

import com.github.dweindl.intellijantimony.AntimonyIcons;
import com.github.dweindl.intellijantimony.AntimonyReference;
import com.github.dweindl.intellijantimony.AntimonyUtil;
import com.github.dweindl.intellijantimony.psi.AntimonyElementFactory;
import com.github.dweindl.intellijantimony.psi.AntimonyIdentifier;
import com.github.dweindl.intellijantimony.psi.AntimonyTypes;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AntimonyPsiImplUtil {

    public static String getName(AntimonyIdentifier element) {
        return element.getNode().getText();
    }

    public static PsiElement setName(AntimonyIdentifier element, String newName) {
        ASTNode idNode = element.getNode().findChildByType(AntimonyTypes.ID);
        if (idNode != null) {
            AntimonyIdentifier identifier = AntimonyElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newIdNode = identifier.getFirstChild().getNode();
            element.getNode().replaceChild(idNode, newIdNode);
        }
        return element;

    }

    public static PsiElement getNameIdentifier(AntimonyIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(AntimonyTypes.ID);
        if (idNode != null) {
            return idNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiReference getReference(AntimonyIdentifier element) {
        return new AntimonyReference(element, new TextRange(0, element.getTextLength()));
    }

    public static PsiReference @NotNull [] getReferences(@NotNull AntimonyIdentifier element) {
        return new PsiReference[]{new AntimonyReference(element, new TextRange(0, element.getTextLength()))};
    }

    public static @Nullable Icon getIcon(final AntimonyIdentifier element, int flags) {
        return AntimonyIcons.getIcon(AntimonyUtil.getModelEntityType(element));
    }

    public static ItemPresentation getPresentation(final AntimonyIdentifier element) {
        // e.g. used for "choose declaration" popup
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getName();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                if (containingFile == null) {
                    return null;
                } else {
                    Project project = element.getProject();
                    PsiDocumentManager psiDocumentManager = PsiDocumentManager.getInstance(project);
                    Document document = psiDocumentManager.getDocument(containingFile);
                    if (document == null) {
                        return null;
                    }
                    int lineNumber = document.getLineNumber(element.getTextOffset()) + 1; // +1 because line numbers are 0-based
                    return containingFile.getName() + " (line " + lineNumber + ")";
                }
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }
}