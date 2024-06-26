package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.github.dweindl.intellijAntimony.psi.AntimonyTypes;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Collection;

final class AntimonyCompletionContributor extends CompletionContributor {
    // Units that are predefined in SBML L3
    final String[] predefined_units_sbml = {
            "ampere", "coulomb", "gray", "joule", "litre", "mole", "radian", "steradian", "weber",
            "avogadro", "dimensionless", "henry", "katal", "lumen", "newton", "second", "tesla",
            "becquerel", "farad", "hertz", "kelvin", "lux", "ohm", "siemens", "volt",
            "candela", "gram", "item", "kilogram", "metre", "pascal", "sievert", "watt"
    };

    AntimonyCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(AntimonyTypes.ID),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        // Add all identifiers in the file to the completion list
                        // Get the current file
                        PsiFile file = parameters.getOriginalFile();

                        // Find all AntimonyIdentifier elements in the file
                        Collection<PsiElement> identifiers = PsiTreeUtil.findChildrenOfType(file, AntimonyIdentifier.class);

                        // For each AntimonyIdentifier, add a completion option to the resultSet
                        for (PsiElement identifier : identifiers) {
                            resultSet.addElement(LookupElementBuilder.create(identifier.getText()).withIcon(
                                    // FIXME for now, we use getModelEntityTypeFromParent instead of getModelEntityType
                                    //  because the latter is too slow
                                    AntimonyIcons.getIcon(AntimonyUtil.getModelEntityTypeFromParent((AntimonyIdentifier) identifier))
                            ));
                        }

                        // If a unit is expected, suggest predefined units
                        PsiElement position = parameters.getPosition();
                        PsiElement parent = position.getParent();
                        if (parent != null) {
                            PsiElement grandParent = parent.getParent();
                            if (grandParent != null && grandParent.getNode().getElementType() == AntimonyTypes.UNIT_ID) {
                                Icon icon = AntimonyIcons.getIcon(AntimonyUtil.ModelEntity.UNIT);

                                for (String unit : predefined_units_sbml) {
                                    resultSet.addElement(LookupElementBuilder.create(unit)
                                            .withIcon(icon));
                                }
                            }
                        }
                    }
                }
        );
    }

}