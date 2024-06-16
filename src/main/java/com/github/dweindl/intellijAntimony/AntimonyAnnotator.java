package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Map;

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
            Map<AntimonyUtil.ModelEntity, String> entityNames = Map.of(
                    AntimonyUtil.ModelEntity.MODULE, "Module",
                    AntimonyUtil.ModelEntity.UNIT, "Unit",
                    AntimonyUtil.ModelEntity.REACTION, "Reaction",
                    AntimonyUtil.ModelEntity.COMPARTMENT, "Compartment",
                    AntimonyUtil.ModelEntity.PARAMETER, "Parameter",
                    AntimonyUtil.ModelEntity.SPECIES, "Species",
                    AntimonyUtil.ModelEntity.EVENT, "Event"
            );
            // shown when hovering an identifier without CTRL pressed
            String description = entityNames.getOrDefault(modelEntity, "Unknown entity") + " " + element.getText();
            holder.newAnnotation(HighlightSeverity.INFORMATION, description)
                    .range(element)
                    .textAttributes(textAttributesKey)
                    .create();
        }
    }
}