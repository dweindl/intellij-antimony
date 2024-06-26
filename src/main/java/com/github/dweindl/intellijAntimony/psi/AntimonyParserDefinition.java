package com.github.dweindl.intellijAntimony.psi;
import com.github.dweindl.intellijAntimony.AntimonyLanguage;
import com.github.dweindl.intellijAntimony.AntimonyLexerAdapter;
import com.github.dweindl.intellijAntimony.parser.AntimonyParser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

final class AntimonyParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(AntimonyLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new AntimonyLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return AntimonyTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return AntimonyTokenSets.STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new AntimonyParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new AntimonyFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return AntimonyTypes.Factory.createElement(node);
    }

}