// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonyLogicalExprImpl extends AntimonyExprImpl implements AntimonyLogicalExpr {

  public AntimonyLogicalExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitLogicalExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyLogicalTerm getLogicalTerm() {
    return findChildByClass(AntimonyLogicalTerm.class);
  }

  @Override
  @Nullable
  public AntimonyOrExpr getOrExpr() {
    return findChildByClass(AntimonyOrExpr.class);
  }

}
