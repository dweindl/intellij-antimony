// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyFunctionDefinition extends PsiElement {

  @Nullable
  AntimonyExpr getExpr();

  @Nullable
  AntimonyFunctionId getFunctionId();

  @Nullable
  AntimonyFunctionSignatureArguments getFunctionSignatureArguments();

}