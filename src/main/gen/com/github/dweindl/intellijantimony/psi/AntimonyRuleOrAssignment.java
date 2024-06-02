// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijantimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyRuleOrAssignment extends PsiElement {

  @Nullable
  AntimonyAssignment getAssignment();

  @Nullable
  AntimonyAssignmentRule getAssignmentRule();

  @Nullable
  AntimonyJustDeclaration getJustDeclaration();

  @Nullable
  AntimonyRateRule getRateRule();

}
