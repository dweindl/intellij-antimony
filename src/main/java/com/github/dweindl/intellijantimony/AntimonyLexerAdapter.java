package com.github.dweindl.intellijantimony;
import com.intellij.lexer.FlexAdapter;

public class AntimonyLexerAdapter extends FlexAdapter {

    public AntimonyLexerAdapter() {
        super(new AntimonyLexer(null));
    }

}