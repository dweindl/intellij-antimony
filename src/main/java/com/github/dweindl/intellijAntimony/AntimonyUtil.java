package com.github.dweindl.intellijAntimony;


import com.github.dweindl.intellijAntimony.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AntimonyUtil {
    public enum ModelEntity {
        SPECIES,
        COMPARTMENT,
        PARAMETER,
        MODULE,
        REACTION,
        UNIT,
        OTHER,
    }

    public static ModelEntity getModelEntityType(AntimonyIdentifier identifier) {
        // Guess type of model entity that this identifier refers to
        // Only works for very few cases
        PsiElement parent = identifier.getParent();
        if (parent != null) {
            if (parent instanceof AntimonyModelId) {
                return ModelEntity.MODULE;
            }
            if (parent instanceof AntimonyUnit) {
                return ModelEntity.UNIT;
            }
            if (parent instanceof AntimonyCompartmentId) {
                return ModelEntity.COMPARTMENT;
            }
            if (parent instanceof AntimonySpeciesId) {
                return ModelEntity.SPECIES;
            }
            if (parent instanceof AntimonyReactionId) {
                return ModelEntity.REACTION;
            }
        }
        return ModelEntity.OTHER;
    }

    /**
     * Searches the entire project for Antimony language files with instances of the identifiers with the given name.
     *
     * @param project    current project
     * @param identifier to check
     * @return matching properties
     */
    public static List<AntimonyIdentifier> findIdentifiers(Project project, String identifier) {
        List<AntimonyIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(AntimonyFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            AntimonyFile antimonyFile = (AntimonyFile) PsiManager.getInstance(project).findFile(virtualFile);
            result.addAll(findIdentifiers(antimonyFile, identifier));
        }
        return result;
    }

    public static List<AntimonyIdentifier> findIdentifiers(AntimonyFile file, String name) {
        List<AntimonyIdentifier> result = new ArrayList<>();
        if (file != null) {
            @NotNull Collection<AntimonyIdentifier> ant_identifiers = PsiTreeUtil.findChildrenOfType(file, AntimonyIdentifier.class);
            for (AntimonyIdentifier ant_id : ant_identifiers) {
                if (name.equals(ant_id.getName())) {
                    result.add(ant_id);
                }
            }
        }
        return result;
    }

    public static List<AntimonyIdentifier> findIdentifiers(Project project) {
        List<AntimonyIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(AntimonyFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            AntimonyFile simpleFile = (AntimonyFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                AntimonyIdentifier[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, AntimonyIdentifier.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }
}