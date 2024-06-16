package com.github.dweindl.intellijAntimony;

import com.intellij.openapi.util.IconLoader;
import com.intellij.ui.JBColor;
import javax.swing.*;

public class AntimonyIcons {
    public static final Icon FILE = IconLoader.getIcon("/icons/antimonyFileIcon.svg", AntimonyIcons.class);
    // public static final Icon FILE = AllIcons.Actions.ArrowExpand;

    public static Icon getIcon(AntimonyUtil.ModelEntity type) {
        return switch (type) {
            case MODULE -> IconCreator.createIconFromString("M", JBColor.RED);
            case SPECIES -> IconCreator.createIconFromString("S", JBColor.YELLOW);
            case COMPARTMENT -> IconCreator.createIconFromString("C", JBColor.BLUE);
            case PARAMETER -> IconCreator.createIconFromString("P", JBColor.MAGENTA);
            case REACTION -> IconCreator.createIconFromString("R", JBColor.GREEN);
            case EVENT -> IconCreator.createIconFromString("E", JBColor.RED);
            case UNIT -> IconCreator.createIconFromString("U", JBColor.GRAY);
            default -> IconCreator.createIconFromString("?", null);
        };
    }
}
