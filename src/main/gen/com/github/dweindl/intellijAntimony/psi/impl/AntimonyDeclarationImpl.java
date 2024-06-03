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

public class AntimonyDeclarationImpl extends ASTWrapperPsiElement implements AntimonyDeclaration {

  public AntimonyDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyCompartmentDeclarationPrefix getCompartmentDeclarationPrefix() {
    return findChildByClass(AntimonyCompartmentDeclarationPrefix.class);
  }

  @Override
  @Nullable
  public AntimonyOtherDeclarationPrefix getOtherDeclarationPrefix() {
    return findChildByClass(AntimonyOtherDeclarationPrefix.class);
  }

  @Override
  @NotNull
  public List<AntimonyRuleOrAssignment> getRuleOrAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyRuleOrAssignment.class);
  }

  @Override
  @Nullable
  public AntimonySpeciesDeclarationPrefix getSpeciesDeclarationPrefix() {
    return findChildByClass(AntimonySpeciesDeclarationPrefix.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

  @Override
  @Nullable
  public PsiElement getLineComment() {
    return findChildByType(LINE_COMMENT);
  }

}
