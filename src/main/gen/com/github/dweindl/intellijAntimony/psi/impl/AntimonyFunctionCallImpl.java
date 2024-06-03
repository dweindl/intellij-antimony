// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonyFunctionCallImpl extends ASTWrapperPsiElement implements AntimonyFunctionCall {

  public AntimonyFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyFunctionArguments getFunctionArguments() {
    return findChildByClass(AntimonyFunctionArguments.class);
  }

  @Override
  @NotNull
  public AntimonyFunctionId getFunctionId() {
    return findNotNullChildByClass(AntimonyFunctionId.class);
  }

}