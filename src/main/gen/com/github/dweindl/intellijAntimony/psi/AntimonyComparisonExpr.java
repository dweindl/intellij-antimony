// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;

public interface AntimonyComparisonExpr extends AntimonyExpr {

  @Nullable
  AntimonyComparisonOp getComparisonOp();

  @NotNull
  List<AntimonyExpr> getExprList();

}
