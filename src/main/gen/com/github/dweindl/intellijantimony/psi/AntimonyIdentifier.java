// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public interface AntimonyIdentifier extends AntimonyNamedElement {

  @NotNull
  PsiElement getId();

  PsiElement getNameIdentifier();

  String getName();

  PsiElement setName(String newName);

  PsiReference getReference();

  PsiReference @NotNull [] getReferences();

  ItemPresentation getPresentation();

}
