// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyDeclaration extends PsiElement {

  @Nullable
  AntimonyCompartmentDeclarationPrefix getCompartmentDeclarationPrefix();

  @Nullable
  AntimonyOtherDeclarationPrefix getOtherDeclarationPrefix();

  @NotNull
  List<AntimonyRuleOrAssignment> getRuleOrAssignmentList();

  @Nullable
  AntimonySpeciesDeclarationPrefix getSpeciesDeclarationPrefix();

  @Nullable
  PsiElement getEol();

  @Nullable
  PsiElement getLineComment();

}
