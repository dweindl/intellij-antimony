// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModule extends PsiElement {

  @NotNull
  AntimonyIdentifier getIdentifier();

  @Nullable
  AntimonyModuleBody getModuleBody();

  @NotNull
  PsiElement getModel();

}
