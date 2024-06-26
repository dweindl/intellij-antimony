package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.github.dweindl.intellijAntimony.psi.AntimonyModuleBody;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntimonyStructureViewModel extends StructureViewModelBase implements
        StructureViewModel.ElementInfoProvider {

    public AntimonyStructureViewModel(@Nullable Editor editor, PsiFile psiFile) {
        super(psiFile, editor, new AntimonyStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter @NotNull [] getSorters() {
        return new Sorter[]{Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element.getValue() instanceof AntimonyIdentifier;
    }

    @Override
    protected Class<?> @NotNull [] getSuitableClasses() {
        // TODO functions?
        return new Class[]{AntimonyModuleBody.class, AntimonyIdentifier.class};
    }

}