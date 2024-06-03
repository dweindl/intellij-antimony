// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonyFunctionArgumentsImpl extends ASTWrapperPsiElement implements AntimonyFunctionArguments {

  public AntimonyFunctionArgumentsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitFunctionArguments(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntimonyExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyExpr.class);
  }

}