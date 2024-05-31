// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyRateRule extends PsiElement {

  @NotNull
  AntimonyExpr getExpr();

  @NotNull
  AntimonyIdentifier getIdentifier();

  @Nullable
  PsiElement getEol();

  @Nullable
  PsiElement getLineComment();

}
