// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi.impl;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dweindl.intellijAntimony.psi.*;

public class AntimonyEventDefinitionImpl extends ASTWrapperPsiElement implements AntimonyEventDefinition {

  public AntimonyEventDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitEventDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntimonyEventAssignments getEventAssignments() {
    return findNotNullChildByClass(AntimonyEventAssignments.class);
  }

  @Override
  @NotNull
  public AntimonyEventTrigger getEventTrigger() {
    return findNotNullChildByClass(AntimonyEventTrigger.class);
  }

}
