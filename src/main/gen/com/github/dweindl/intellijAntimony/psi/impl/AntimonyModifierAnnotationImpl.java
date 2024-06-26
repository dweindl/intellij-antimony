// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dweindl.intellijAntimony.psi.AntimonyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonyModifierAnnotationImpl extends ASTWrapperPsiElement implements AntimonyModifierAnnotation {

  public AntimonyModifierAnnotationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitModifierAnnotation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyModifierId getModifierId() {
    return findChildByClass(AntimonyModifierId.class);
  }

  @Override
  @NotNull
  public AntimonyReactionId getReactionId() {
    return findNotNullChildByClass(AntimonyReactionId.class);
  }

  @Override
  @NotNull
  public AntimonySpeciesId getSpeciesId() {
    return findNotNullChildByClass(AntimonySpeciesId.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

}
