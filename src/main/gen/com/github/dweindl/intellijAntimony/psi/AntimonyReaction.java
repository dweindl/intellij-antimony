// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyReaction extends PsiElement {

  @NotNull
  AntimonyExpr getExpr();

  @Nullable
  AntimonyProducts getProducts();

  @Nullable
  AntimonyReactants getReactants();

  @Nullable
  AntimonyReactionId getReactionId();

  @Nullable
  PsiElement getEol();

}
