package com.github.dweindl.intellijantimony.psi.impl;
// import com.github.dweindl.intellijantimony.psi.AntimonyProperty;
import com.github.dweindl.intellijantimony.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AntimonyPsiImplUtil {
/*
    public static String getKey(AntimonyProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(AntimonyTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(AntimonyProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(AntimonyTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }
*/
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
/*
    public static ItemPresentation getPresentation(final AntimonyProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

 */

}