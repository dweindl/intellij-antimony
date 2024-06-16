package com.github.dweindl.intellijAntimony;


import com.github.dweindl.intellijAntimony.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class AntimonyUtil {
    public enum ModelEntity {
        SPECIES,
        COMPARTMENT,
        PARAMETER,
        MODULE,
        REACTION,
        UNIT,
        EVENT,
        OTHER,
    }


    public static ModelEntity getModelEntityTypeFromParent(AntimonyIdentifier identifier) {
        PsiElement parent = identifier.getParent();
        if (parent != null) {
            if (parent instanceof AntimonyModelId) {
                return ModelEntity.MODULE;
            }
            if (parent instanceof AntimonyUnitId) {
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
            if (parent instanceof AntimonyEventId) {
                return ModelEntity.EVENT;
            }
            if (PsiTreeUtil.getParentOfType(identifier, AntimonyUnitDefinition.class) != null) {
                return ModelEntity.UNIT;
            }
        }
        return ModelEntity.OTHER;
    }

    public static ModelEntity getModelEntityType(AntimonyIdentifier identifier) {
        ModelEntity type = getModelEntityTypeFromParent(identifier);

        if (type != ModelEntity.OTHER) {
            return type;
        }
        //  find out whether there was any declaration of this identifier that clarifies its type
        @Nullable AntimonyModuleBody moduleBody = PsiTreeUtil.getParentOfType(identifier, AntimonyModuleBody.class);
        if (moduleBody == null) {
            return ModelEntity.OTHER;
        }

        // FIXME: this is pretty expensive for larger models, because on every change,
        //  we need to visit the AST of the entire module several times, this leads to slow
        //  structure view updates and slow code completion
        return new PsiRecursiveElementWalkingVisitor() {
            ModelEntity type = ModelEntity.OTHER;
            String id = null;

            @Override
            public void visitElement(@NotNull PsiElement element) {
                super.visitElement(element);

                if (element instanceof AntimonyIdentifier) {
                    if (!Objects.equals(((AntimonyIdentifier) element).getName(), id)) {
                        return;
                    }
                    ModelEntity type = getModelEntityTypeFromParent(identifier);

                    if (type != ModelEntity.OTHER) {
                        this.type = type;
                        stopWalking();
                    }
                }
            }

            ModelEntity getType(PsiElement element, String id) {
                this.id = id;
                visitElement(element);
                return type != ModelEntity.OTHER ? type : ModelEntity.PARAMETER;
            }
        }.getType(moduleBody, identifier.getName());
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