// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;

public interface AntimonyMulExpr extends AntimonyExpr {

  @NotNull
  List<AntimonyExpr> getExprList();

  @NotNull
  List<AntimonyFunctionCall> getFunctionCallList();

}