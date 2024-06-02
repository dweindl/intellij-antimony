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

public class AntimonyModelImportImpl extends ASTWrapperPsiElement implements AntimonyModelImport {

  public AntimonyModelImportImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntimonyVisitor visitor) {
    visitor.visitModelImport(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntimonyVisitor) accept((AntimonyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntimonyExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyExpr.class);
  }

  @Override
  @Nullable
  public AntimonyFunctionSignatureArguments getFunctionSignatureArguments() {
    return findChildByClass(AntimonyFunctionSignatureArguments.class);
  }

  @Override
  @NotNull
  public List<AntimonyModelId> getModelIdList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntimonyModelId.class);
  }

  @Override
  @Nullable
  public PsiElement getEol() {
    return findChildByType(EOL);
  }

}
