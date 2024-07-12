// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyAnnotation extends PsiElement {

  @NotNull
  AntimonyAnnotationKeywords getAnnotationKeywords();

  @NotNull
  AntimonyIdentifier getIdentifier();

  @Nullable
  PsiElement getMultilineString();

}
