package com.github.dweindl.intellijantimony;

import com.github.dweindl.intellijantimony.psi.AntimonyIdentifier;
import com.intellij.psi.PsiElement;
import com.intellij.refactoring.rename.RenamePsiElementProcessor;
import org.jetbrains.annotations.NotNull;


public class AntimonyRenameProcessor extends RenamePsiElementProcessor {
    @Override
    public boolean canProcessElement(@NotNull PsiElement element) {
        return element instanceof AntimonyIdentifier;
    }
}