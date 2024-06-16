// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModuleBody extends PsiElement {

  @NotNull
  List<AntimonyAnnotation> getAnnotationList();

  @NotNull
  List<AntimonyCurrentModelAnnotation> getCurrentModelAnnotationList();

  @NotNull
  List<AntimonyDeclaration> getDeclarationList();

  @NotNull
  List<AntimonyEventDefinition> getEventDefinitionList();

  @NotNull
  List<AntimonyFileImport> getFileImportList();

  @NotNull
  List<AntimonyFunctionDefinition> getFunctionDefinitionList();

  @NotNull
  List<AntimonyModelImport> getModelImportList();

  @NotNull
  List<AntimonyModifierAnnotation> getModifierAnnotationList();

  @NotNull
  List<AntimonyReaction> getReactionList();

  @NotNull
  List<AntimonyUnitAnnotation> getUnitAnnotationList();

  @NotNull
  List<AntimonyUnitDefinition> getUnitDefinitionList();

}
