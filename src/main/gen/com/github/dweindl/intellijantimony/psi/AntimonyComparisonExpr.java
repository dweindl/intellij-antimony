// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyComparisonExpr extends AntimonyExpr {

  @Nullable
  AntimonyComparisonOp getComparisonOp();

  @NotNull
  List<AntimonyExpr> getExprList();

}
