// This is a generated file. Not intended for manual editing.
package com.github.dweindl.intellijAntimony.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntimonyEventDefinition extends PsiElement {

  @NotNull
  AntimonyEventAssignments getEventAssignments();

  @Nullable
  AntimonyEventId getEventId();

  @NotNull
  AntimonyEventTrigger getEventTrigger();

}
