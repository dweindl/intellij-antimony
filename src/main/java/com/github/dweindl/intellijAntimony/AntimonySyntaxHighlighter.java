package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyTokenSets;
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
    // Each TextAttributesKey is a unique identifier for a set of text attributes for highlighting.
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

    // Lists of TextAttributesKeys for different types of tokens - attributes will be merged
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
        if (AntimonyTokenSets.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        }
        if (AntimonyTokenSets.STRINGS.contains(tokenType)) {
            return STRING_KEYS;
        }
        if (AntimonyTokenSets.NUMBERS.contains(tokenType)) {
            return NUMBER_KEYS;
        }
        if (AntimonyTokenSets.IDENTIFIERS.contains(tokenType)) {
            return ID_KEYS;
        }
        if (AntimonyTokenSets.COMMENTS.contains(tokenType)) {
            return COMMENT_KEYS;
        }
        if (AntimonyTokenSets.PARENTHESES.contains(tokenType)) {
            return PARENTHESIS_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }

}