package com.github.dweindl.intellijantimony.psi.impl;

import com.github.dweindl.intellijantimony.psi.AntimonyNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class AntimonyNamedElementImpl extends ASTWrapperPsiElement implements AntimonyNamedElement {

    public AntimonyNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}