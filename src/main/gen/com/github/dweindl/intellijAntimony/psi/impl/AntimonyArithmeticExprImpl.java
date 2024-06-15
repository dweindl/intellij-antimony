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

public class AntimonyArithmeticExprImpl extends AntimonyExprImpl implements AntimonyArithmeticExpr {

  public AntimonyArithmeticExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitArithmeticExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntimonyExpr getExpr() {
    return findChildByClass(AntimonyExpr.class);
  }

  @Override
  @Nullable
  public AntimonyFunctionCall getFunctionCall() {
    return findChildByClass(AntimonyFunctionCall.class);
  }

}
