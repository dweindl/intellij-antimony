package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.*;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class AntimonyFindUsagesProvider implements FindUsagesProvider {

    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new AntimonyLexerAdapter(),
                AntimonyTokenSets.IDENTIFIERS,
                AntimonyTokenSets.COMMENTS,
                AntimonyTokenSets.LITERALS);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        // TODO refactor, out of here,  getTypeOfId()
        // get parent of element
        PsiElement parent = element.getParent();
        if (parent != null) {
            if (parent instanceof AntimonyModelId) {
                return "Model module";
            }

            if (parent instanceof AntimonyUnit) {
                return "Unit";
            }

            if (parent instanceof AntimonyCompartmentId) {
                return "Compartment";
            }

            if (parent instanceof AntimonySpeciesId) {
                return "Species";
            }

            if (parent instanceof AntimonyReactionId) {
                return "Reaction";
            }
        }

        if (element instanceof AntimonyIdentifier) {
            return "Unspecified identifier";
        }
        return "TODO AntimonyFindUsagesProvider::getType()";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof AntimonyIdentifier) {
            return ((AntimonyIdentifier) element).getText();
        }
        return "TODO AntimonyFindUsagesProvider::getDescriptiveName()";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        return "TODO AntimonyFindUsagesProvider::getNodeText()";
    }

}