// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dweindl.intellijantimony.psi.AntimonyTypes.*;
import com.github.dweindl.intellijantimony.psi.*;

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
