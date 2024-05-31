// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyUnitAnnotation extends PsiElement {

  @NotNull
  AntimonyIdentifier getIdentifier();

  @NotNull
  AntimonyUnit getUnit();

  @Nullable
  PsiElement getEol();

}
