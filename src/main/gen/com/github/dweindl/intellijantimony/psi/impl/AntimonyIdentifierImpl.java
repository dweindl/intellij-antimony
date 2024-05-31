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

public class AntimonyIdentifierImpl extends AntimonyNamedElementImpl implements AntimonyIdentifier {

  public AntimonyIdentifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitIdentifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getId() {
    return findNotNullChildByType(ID);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return AntimonyPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return AntimonyPsiImplUtil.setName(this, newName);
  }

}
