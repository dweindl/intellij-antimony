package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AntimonySyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey ID =
            createTextAttributesKey("ANTIMONY_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("ANTIMONY_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("ANTIMONY_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("ANTIMONY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("ANTIMONY_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("ANTIMONY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("ANTIMONY_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey PARENTHESIS =
            createTextAttributesKey("ANTIMONY_PARENTHESIS", DefaultLanguageHighlighterColors.PARENTHESES);
    private static final TextAttributesKey[] ID_KEYS = new TextAttributesKey[]{ID};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] PARENTHESIS_KEYS = new TextAttributesKey[]{PARENTHESIS};

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new AntimonyLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        /*
        if (tokenType.equals(AntimonyTypes.SEPARATOR)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(AntimonyTypes.KEY)) {
            return KEY_KEYS;
        }
        */
        if (tokenType.equals(AntimonyTypes.UNIT_KEYWORD)
                || tokenType.equals(AntimonyTypes.AT )
                || tokenType.equals(AntimonyTypes.IN)
                || tokenType.equals(AntimonyTypes.END)
                || tokenType.equals(AntimonyTypes.IS)
                || tokenType.equals(AntimonyTypes.HAS)
                || tokenType.equals(AntimonyTypes.MODEL)
                || tokenType.equals(AntimonyTypes.NOTES)
                || tokenType.equals(AntimonyTypes.VAR)
                || tokenType.equals(AntimonyTypes.SPECIES)
                || tokenType.equals(AntimonyTypes.COMPARTMENT)
                || tokenType.equals(AntimonyTypes.CONST)
                || tokenType.equals(AntimonyTypes.SUBSTANCE_ONLY)
                || tokenType.equals(AntimonyTypes.FUNCTION)
                || tokenType.equals(AntimonyTypes.IDENTITY)
                || tokenType.equals(AntimonyTypes.PART)
                || tokenType.equals(AntimonyTypes.IMPORT)
                || tokenType.equals(AntimonyTypes.TIMECONV)
                || tokenType.equals(AntimonyTypes.EXTENTCONV)
            // TODO : use tokensets?
        ) {
            return KEYWORD_KEYS;
        }

        if (tokenType.equals(AntimonyTypes.STRING)) {
            return STRING_KEYS;
        }
        if (
                tokenType.equals(AntimonyTypes.NUMBER_LITERAL)
                || tokenType.equals(AntimonyTypes.SCIENTIFIC)
                || tokenType.equals(AntimonyTypes.INT)
                || tokenType.equals(AntimonyTypes.FLOAT)
        ) {
            return NUMBER_KEYS;
        }
        if (
                tokenType.equals(AntimonyTypes.ID)
                || tokenType.equals(AntimonyTypes.UNIT)
                || tokenType.equals(AntimonyTypes.SPECIES_ID)
                || tokenType.equals(AntimonyTypes.COMPARTMENT_ID)
                || tokenType.equals(AntimonyTypes.REACTION_ID)
        ) {
            return ID_KEYS;
        }
        if (tokenType.equals(AntimonyTypes.LINE_COMMENT) || tokenType.equals(AntimonyTypes.BLOCK_COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(AntimonyTypes.LPAREN) || tokenType.equals(AntimonyTypes.RPAREN)) {
            return PARENTHESIS_KEYS;
        }
        // TODO FUNCTION_CALL
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}