package com.github.dweindl.intellijAntimony;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntimonyCommenter implements Commenter {
    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return "# ";
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return "/*";
    }

    @Override
    public @NotNull List<String> getLineCommentPrefixes() {
        return List.of("#", "//");
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return "*/";
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}