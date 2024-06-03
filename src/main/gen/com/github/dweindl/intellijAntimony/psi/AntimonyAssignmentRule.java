// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyAssignmentRule extends PsiElement {

  @Nullable
  AntimonyCompartmentId getCompartmentId();

  @Nullable
  AntimonyExpr getExpr();

  @NotNull
  AntimonyIdentifier getIdentifier();

}
