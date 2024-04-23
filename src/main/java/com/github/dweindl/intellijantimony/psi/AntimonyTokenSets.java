package com.github.dweindl.intellijantimony.psi;
import com.intellij.psi.tree.TokenSet;

public interface AntimonyTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(AntimonyTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(AntimonyTypes.COMMENT);

}
