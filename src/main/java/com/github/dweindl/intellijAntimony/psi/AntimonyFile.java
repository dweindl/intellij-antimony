package com.github.dweindl.intellijAntimony.psi;

import com.github.dweindl.intellijAntimony.AntimonyFileType;
import com.github.dweindl.intellijAntimony.AntimonyLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class AntimonyFile extends PsiFileBase {

    public AntimonyFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AntimonyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AntimonyFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Antimony File";
    }

}