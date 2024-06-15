package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
// import com.intellij.psi.PsiLiteralExpression;
// import org.intellij.sdk.language.psi.SimpleProperty;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

final class AntimonyAnnotator implements Annotator, DumbAware {


    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof AntimonyIdentifier) {
            AntimonyUtil.ModelEntity modelEntity = AntimonyUtil.getModelEntityType((AntimonyIdentifier) element);
            TextAttributesKey textAttributesKey = switch (modelEntity) {
                case MODULE -> AntimonySyntaxHighlighter.MODULE_ID;
                case UNIT -> AntimonySyntaxHighlighter.UNITS;
                case REACTION -> AntimonySyntaxHighlighter.REACTION_ID;
                case COMPARTMENT -> AntimonySyntaxHighlighter.COMPARTMENT_ID;
                default -> AntimonySyntaxHighlighter.ID;
            };
            holder.newAnnotation(HighlightSeverity.INFORMATION, "")
                    .range(element)
                    .textAttributes(textAttributesKey)
                    .create();
        }
    }
}