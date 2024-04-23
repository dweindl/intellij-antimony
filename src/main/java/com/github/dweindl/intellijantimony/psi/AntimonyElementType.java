package com.github.dweindl.intellijantimony.psi;

import com.github.dweindl.intellijantimony.AntimonyLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AntimonyElementType extends IElementType {

    public AntimonyElementType(@NotNull @NonNls String debugName) {
        super(debugName, AntimonyLanguage.INSTANCE);
    }

}