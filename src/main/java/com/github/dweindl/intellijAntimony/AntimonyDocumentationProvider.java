package com.github.dweindl.intellijAntimony;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;

public class AntimonyDocumentationProvider extends AbstractDocumentationProvider {
    @Override
    public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        // This is the tooltip shown when hovering an identifier with CTRL pressed
        if (element instanceof AntimonyIdentifier identifier) {
            // TODO: provide more information about the identifier
            return "Identifier: " + identifier.getName();
        }
        return null;
    }
}