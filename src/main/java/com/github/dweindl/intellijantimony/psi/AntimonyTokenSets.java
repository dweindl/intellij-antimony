package com.github.dweindl.intellijantimony.psi;
import com.intellij.psi.tree.TokenSet;

public interface AntimonyTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(AntimonyTypes.ID);
    TokenSet STRINGS = TokenSet.create(AntimonyTypes.STRING);
    TokenSet NUMBERS = TokenSet.create(AntimonyTypes.NUMBER_LITERAL);
    TokenSet COMMENTS = TokenSet.create(AntimonyTypes.BLOCK_COMMENT, AntimonyTypes.LINE_COMMENT);
    TokenSet LITERALS = TokenSet.orSet(STRINGS, NUMBERS);
}
