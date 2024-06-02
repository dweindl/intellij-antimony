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

public class AntimonyRuleOrAssignmentImpl extends ASTWrapperPsiElement implements AntimonyRuleOrAssignment {

  public AntimonyRuleOrAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitRuleOrAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyAssignment getAssignment() {
    return findChildByClass(AntimonyAssignment.class);
  }

  @Override
  @Nullable
  public AntimonyAssignmentRule getAssignmentRule() {
    return findChildByClass(AntimonyAssignmentRule.class);
  }

  @Override
  @Nullable
  public AntimonyJustDeclaration getJustDeclaration() {
    return findChildByClass(AntimonyJustDeclaration.class);
  }

  @Override
  @Nullable
  public AntimonyRateRule getRateRule() {
    return findChildByClass(AntimonyRateRule.class);
  }

}
