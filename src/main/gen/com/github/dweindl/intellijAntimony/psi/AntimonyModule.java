// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyModule extends PsiElement {

  @Nullable
  AntimonyFunctionSignatureArguments getFunctionSignatureArguments();

  @Nullable
  AntimonyModelId getModelId();

  @Nullable
  AntimonyModuleBody getModuleBody();

  @NotNull
  PsiElement getModel();

}
