// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModelAnnotation extends PsiElement {

  @NotNull
  AntimonyAnnotationType getAnnotationType();

  @NotNull
  AntimonyModelId getModelId();

  @Nullable
  PsiElement getEol();

  @NotNull
  PsiElement getString();

}
