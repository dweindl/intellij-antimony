package com.github.dweindl.intellijantimony.psi;


import com.github.dweindl.intellijantimony.AntimonyLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AntimonyTokenType extends IElementType {

    public AntimonyTokenType(@NotNull @NonNls String debugName) {
        super(debugName, AntimonyLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "AntimonyTokenType." + super.toString();
    }

}