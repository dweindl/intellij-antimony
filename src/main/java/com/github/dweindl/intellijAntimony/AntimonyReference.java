package com.github.dweindl.intellijAntimony;


import com.github.dweindl.intellijAntimony.psi.AntimonyFile;
import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class AntimonyReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String identifier;

    public AntimonyReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        identifier = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }


    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        // Project project = myElement.getProject();
        // final List<AntimonyIdentifier> properties = AntimonyUtil.findIdentifiers(project, identifier);
        // Resolve only within the current file for now (needs to change for hierarchical models)
        AntimonyFile file = (AntimonyFile) myElement.getContainingFile();
        final List<AntimonyIdentifier> properties = AntimonyUtil.findIdentifiers(file, identifier);
        List<ResolveResult> results = new ArrayList<>();
        for (AntimonyIdentifier property : properties) {
            results.add(new PsiElementResolveResult(property));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        /*
        What is to be considered the declaration in Antimony?
        For now, we use the first occurrence of the identifier in the file?
        */
        // This will show the "Choose declaration" popup, but it will break "find usages"
        // return resolveResults.length == 1 ? resolveResults[0].getElement() : null;

        // "Find usages" works only if resolve() returns a single element (independent of multiResolve())
        return resolveResults.length >= 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        // Project project = myElement.getProject();
        // List<AntimonyIdentifier> properties = AntimonyUtil.findIdentifiers(project);
        AntimonyFile file = (AntimonyFile) myElement.getContainingFile();
        final List<AntimonyIdentifier> properties = AntimonyUtil.findIdentifiers(file, identifier);
        List<LookupElement> variants = new ArrayList<>();
        for (final AntimonyIdentifier property : properties) {
            if (property.getNameIdentifier() != null) {
                variants.add(LookupElementBuilder
                        .create(property)
                        .withIcon(AntimonyIcons.FILE)
                        .withPresentableText(property.getName())
                        .withTypeText(property.getContainingFile().getName())
                        .withTailText(" (" + property.getTextOffset() + ")", true)
                        .bold()
                );
            }
        }
        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
        return ((AntimonyIdentifier) myElement).setName(newElementName);
    }
}