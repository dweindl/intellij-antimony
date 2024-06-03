// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModifierAnnotation extends PsiElement {

  @Nullable
  AntimonyModifierId getModifierId();

  @NotNull
  AntimonyReactionId getReactionId();

  @NotNull
  AntimonySpeciesId getSpeciesId();

  @Nullable
  PsiElement getEol();

}
