// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dweindl.intellijAntimony.psi.AntimonyTypes.*;
import com.github.dweindl.intellijAntimony.psi.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;
import javax.swing.Icon;

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
  public String getName() {
    return AntimonyPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return AntimonyPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiReference getReference() {
    return AntimonyPsiImplUtil.getReference(this);
  }

  @Override
  public PsiReference @NotNull [] getReferences() {
    return AntimonyPsiImplUtil.getReferences(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return AntimonyPsiImplUtil.getPresentation(this);
  }

  @Override
  public @Nullable Icon getIcon(int flags) {
    return AntimonyPsiImplUtil.getIcon(this, flags);
  }

}
