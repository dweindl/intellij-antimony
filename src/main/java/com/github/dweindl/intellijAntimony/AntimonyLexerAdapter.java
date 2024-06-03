package com.github.dweindl.intellijAntimony;
import com.intellij.lexer.FlexAdapter;

public class AntimonyLexerAdapter extends FlexAdapter {

    public AntimonyLexerAdapter() {
        super(new _AntimonyLexer(null));
    }

}