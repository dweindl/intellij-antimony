package com.github.dweindl.intellijAntimony;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

final class AntimonyColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", AntimonySyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Separator", AntimonySyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("ID", AntimonySyntaxHighlighter.ID),
            new AttributesDescriptor("ID//Units", AntimonySyntaxHighlighter.UNITS),
            new AttributesDescriptor("ID//Module ID", AntimonySyntaxHighlighter.MODULE_ID),
            new AttributesDescriptor("ID//Reaction ID", AntimonySyntaxHighlighter.REACTION_ID),
            new AttributesDescriptor("ID//Compartment ID", AntimonySyntaxHighlighter.COMPARTMENT_ID),
            new AttributesDescriptor("String", AntimonySyntaxHighlighter.STRING),
            new AttributesDescriptor("Number", AntimonySyntaxHighlighter.NUMBER),
            new AttributesDescriptor("Line comment", AntimonySyntaxHighlighter.LINE_COMMENT),
            new AttributesDescriptor("Block comment", AntimonySyntaxHighlighter.BLOCK_COMMENT),
            new AttributesDescriptor("Parenthesis", AntimonySyntaxHighlighter.PARENTHESIS),
            new AttributesDescriptor("Operator", AntimonySyntaxHighlighter.OPERATORS),
            new AttributesDescriptor("Bad value", AntimonySyntaxHighlighter.BAD_CHARACTER)
    };

    @Override
    public Icon getIcon() {
        return AntimonyIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new AntimonySyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return """
        # This is a comment
        model test()
            // This is another comment
            x = 1 dimensionless
        
            /*
            This is a block comment
            */
            y := 2
            y has litre
            species z = 3
        
            R: x -> y; 0.1
            R notes "some reaction"
        
            compartment compartment1
            rate_rule_target' = 1
        end
        """;
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Antimony";
    }

}