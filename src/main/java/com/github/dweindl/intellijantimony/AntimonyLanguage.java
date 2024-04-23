package com.github.dweindl.intellijantimony;

import com.intellij.lang.Language;

public class AntimonyLanguage extends Language {

    public static final AntimonyLanguage INSTANCE = new AntimonyLanguage();

    private AntimonyLanguage() {
        super("Antimony");
    }

}