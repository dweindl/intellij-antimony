// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModuleBody extends PsiElement {

  @NotNull
  List<AntimonyAnnotation> getAnnotationList();

  @NotNull
  List<AntimonyDeclaration> getDeclarationList();

  @NotNull
  List<AntimonyEventDefinition> getEventDefinitionList();

  @NotNull
  List<AntimonyFunctionDefinition> getFunctionDefinitionList();

  @NotNull
  List<AntimonyModifierAnnotation> getModifierAnnotationList();

  @NotNull
  List<AntimonyReaction> getReactionList();

  @NotNull
  List<AntimonyUnitAnnotation> getUnitAnnotationList();

  @NotNull
  List<AntimonyUnitDefinition> getUnitDefinitionList();

}
