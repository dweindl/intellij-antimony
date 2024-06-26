package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.*;
import com.github.dweindl.intellijAntimony.psi.impl.AntimonyIdentifierImpl;
import com.github.dweindl.intellijAntimony.psi.impl.AntimonyModuleBodyImpl;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class AntimonyStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement myElement;

    public AntimonyStructureViewElement(NavigatablePsiElement element) {
        this.myElement = element;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        String name = myElement.getName();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = myElement.getPresentation();
        if (presentation != null)
            return presentation;

        if (myElement instanceof AntimonyModuleBody) {
            // try to find enclosing module
            AntimonyModule module = PsiTreeUtil.getParentOfType(myElement, AntimonyModule.class);
            // find its ID
            AntimonyIdentifier id = module != null ? PsiTreeUtil.findChildOfType(module, AntimonyIdentifier.class) : null;

            String moduleName = id != null ? id.getName() : "__main";
            return new PresentationData(moduleName, null, null, null);
        } else if (myElement instanceof AntimonyIdentifier) {
            return new PresentationData(myElement.getName(), null, null, null);
        }
        return new PresentationData();
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (myElement instanceof AntimonyFile) {
            @NotNull Collection<AntimonyModuleBody> modules = PsiTreeUtil.findChildrenOfType(myElement, AntimonyModuleBody.class);
            List<TreeElement> treeElements = new ArrayList<>(modules.size());
            for (AntimonyModuleBody module : modules) {
                treeElements.add(new AntimonyStructureViewElement((AntimonyModuleBodyImpl) module));
            }
            return treeElements.toArray(new TreeElement[0]);
        }
        if (myElement instanceof AntimonyModuleBody) {
            @NotNull Collection<AntimonyIdentifier> identifiers = PsiTreeUtil.findChildrenOfType(myElement, AntimonyIdentifier.class);
            List<TreeElement> treeElements = new ArrayList<>(identifiers.size());
            for (AntimonyIdentifier identifier : identifiers) {
                // only show declarations, not references from expressions
                if(PsiTreeUtil.getParentOfType(identifier, AntimonyExpr.class) != null)
                    continue;
                // skip units from "a has b" declarations
                if(PsiTreeUtil.getParentOfType(identifier, AntimonyUnitId.class) != null
                        && PsiTreeUtil.getParentOfType(identifier, AntimonyUnitAnnotation.class) != null)
                    continue;
                // skip compartment from "a in b" declarations
                // check for "in" token just before the identifier
                boolean is_assigned_compartment = false;
                PsiElement sibling = identifier.getParent().getPrevSibling();
                while (sibling != null) {
                    // check for "in" token
                    if (Objects.equals(sibling.getText(), "in")) {
                        is_assigned_compartment = true;
                        break;
                    }
                    sibling = sibling.getPrevSibling();
                }
                if (is_assigned_compartment)
                    continue;
                // don't repeat the previous element
                if(!treeElements.isEmpty() && Objects.equals(((AntimonyIdentifier) ((AntimonyStructureViewElement) treeElements.get(treeElements.size() - 1)).getValue()).getName(), identifier.getName()))
                    continue;
                treeElements.add(new AntimonyStructureViewElement((AntimonyIdentifierImpl) identifier));
            }
            // TODO add unnamed reactions and events
            return treeElements.toArray(new TreeElement[0]);
        }
        return EMPTY_ARRAY;
    }

}