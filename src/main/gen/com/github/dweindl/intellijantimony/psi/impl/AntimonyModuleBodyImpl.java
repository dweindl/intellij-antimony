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

public class AntimonyModuleBodyImpl extends ASTWrapperPsiElement implements AntimonyModuleBody {

  public AntimonyModuleBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitModuleBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntimonyAnnotation> getAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyAnnotation.class);
  }

  @Override
  @NotNull
  public List<AntimonyAnnotationIs> getAnnotationIsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyAnnotationIs.class);
  }

  @Override
  @NotNull
  public List<AntimonyAssignment> getAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyAssignment.class);
  }

  @Override
  @NotNull
  public List<AntimonyAssignmentRule> getAssignmentRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyAssignmentRule.class);
  }

  @Override
  @NotNull
  public List<AntimonyDeclaration> getDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyDeclaration.class);
  }

  @Override
  @NotNull
  public List<AntimonyEventDefinition> getEventDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyEventDefinition.class);
  }

  @Override
  @NotNull
  public List<AntimonyModifierAnnotation> getModifierAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyModifierAnnotation.class);
  }

  @Override
  @NotNull
  public List<AntimonyRateRule> getRateRuleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyRateRule.class);
  }

  @Override
  @NotNull
  public List<AntimonyReaction> getReactionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyReaction.class);
  }

  @Override
  @NotNull
  public List<AntimonyUnitAnnotation> getUnitAnnotationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyUnitAnnotation.class);
  }

  @Override
  @NotNull
  public List<AntimonyUnitDefinition> getUnitDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyUnitDefinition.class);
  }

}
