// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dweindl.intellijantimony.psi.AntimonyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dweindl.intellijantimony.psi.*;

public class AntimonyReactionImpl extends ASTWrapperPsiElement implements AntimonyReaction {

  public AntimonyReactionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitReaction(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntimonyExpr getExpr() {
    return findNotNullChildByClass(AntimonyExpr.class);
  }

  @Override
  @Nullable
  public AntimonyProducts getProducts() {
    return findChildByClass(AntimonyProducts.class);
  }

  @Override
  @Nullable
  public AntimonyReactants getReactants() {
    return findChildByClass(AntimonyReactants.class);
  }

  @Override
  @Nullable
  public AntimonyReactionId getReactionId() {
    return findChildByClass(AntimonyReactionId.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

}
