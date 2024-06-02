// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
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
