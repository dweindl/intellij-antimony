// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyAssignment extends PsiElement {

  @NotNull
  AntimonyDeclarationBody getDeclarationBody();

  @NotNull
  AntimonyExpr getExpr();

  @Nullable
  PsiElement getEol();

  @Nullable
  PsiElement getLineComment();

}
