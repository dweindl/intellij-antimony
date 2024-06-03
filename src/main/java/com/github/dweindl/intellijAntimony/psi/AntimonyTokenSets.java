package com.github.dweindl.intellijAntimony.psi;

import com.intellij.psi.tree.TokenSet;

public interface AntimonyTokenSets {
    TokenSet IDENTIFIERS = TokenSet.create(AntimonyTypes.ID);
    TokenSet STRINGS = TokenSet.create(
            AntimonyTypes.STRING,
            AntimonyTypes.MULTILINE_STRING
    );
    TokenSet NUMBERS = TokenSet.create(
            AntimonyTypes.NUMBER_LITERAL,
            AntimonyTypes.SCIENTIFIC,
            AntimonyTypes.INT,
            AntimonyTypes.FLOAT
    );
    TokenSet COMMENTS = TokenSet.create(
            AntimonyTypes.BLOCK_COMMENT,
            AntimonyTypes.LINE_COMMENT
    );
    TokenSet LITERALS = TokenSet.orSet(STRINGS, NUMBERS);
    TokenSet WHITESPACE = TokenSet.create(AntimonyTypes.EOL);
    TokenSet OPERATORS = TokenSet.create(
            AntimonyTypes.PLUS,
            AntimonyTypes.MINUS,
            AntimonyTypes.MUL,
            AntimonyTypes.DIV,
            AntimonyTypes.POW,
            AntimonyTypes.EQ,
            AntimonyTypes.NEQ,
            AntimonyTypes.LT,
            AntimonyTypes.GT,
            AntimonyTypes.LTE,
            AntimonyTypes.GTE,
            AntimonyTypes.AND,
            AntimonyTypes.OR,
            AntimonyTypes.NOT,
            AntimonyTypes.ASSIGN_EQ
    );
    TokenSet KEYWORDS = TokenSet.create(
            AntimonyTypes.UNIT_KEYWORD,
            AntimonyTypes.AT,
            AntimonyTypes.IN,
            AntimonyTypes.END,
            AntimonyTypes.IS,
            AntimonyTypes.HAS,
            AntimonyTypes.MODEL,
            AntimonyTypes.NOTES,
            AntimonyTypes.VAR,
            AntimonyTypes.SPECIES,
            AntimonyTypes.COMPARTMENT,
            AntimonyTypes.CONST,
            AntimonyTypes.SUBSTANCE_ONLY,
            AntimonyTypes.FUNCTION,
            AntimonyTypes.IDENTITY,
            AntimonyTypes.PART,
            AntimonyTypes.IMPORT,
            AntimonyTypes.TIMECONV,
            AntimonyTypes.EXTENTCONV
    );
    TokenSet SEPARATORS = TokenSet.create(
            AntimonyTypes.COMMA,
            AntimonyTypes.COLON,
            AntimonyTypes.SEMI,
            AntimonyTypes.LPAREN,
            AntimonyTypes.RPAREN
    );
    TokenSet PARENTHESES = TokenSet.create(AntimonyTypes.LPAREN, AntimonyTypes.RPAREN);
}
