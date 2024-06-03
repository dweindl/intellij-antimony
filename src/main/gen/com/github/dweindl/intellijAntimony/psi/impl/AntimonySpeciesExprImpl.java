// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonySpeciesExprImpl extends AntimonyExprImpl implements AntimonySpeciesExpr {

  public AntimonySpeciesExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitSpeciesExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntimonySpeciesId getSpeciesId() {
    return findNotNullChildByClass(AntimonySpeciesId.class);
  }

  @Override
  @Nullable
  public AntimonyStoichiometry getStoichiometry() {
    return findChildByClass(AntimonyStoichiometry.class);
  }

}
