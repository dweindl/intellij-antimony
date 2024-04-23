package com.github.dweindl.intellijantimony;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class AntimonyFileType extends LanguageFileType {

    public static final AntimonyFileType INSTANCE = new AntimonyFileType();

    private AntimonyFileType() {
        super(AntimonyLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Antimony File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Antimony model file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ant";
    }

    @Override
    public Icon getIcon() {
        return AntimonyIcons.FILE;
    }

}