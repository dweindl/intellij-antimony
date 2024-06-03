package com.github.dweindl.intellijAntimony;

import com.intellij.icons.AllIcons;
// import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public class AntimonyIcons {
    // public static final Icon FILE = IconLoader.getIcon("/icons/jar-gray.png", AntimonyIcons.class);
    public static final Icon FILE = AllIcons.Actions.ArrowExpand;

    public static Icon getIcon(AntimonyUtil.ModelEntity type) {
        return switch (type) {
            case MODULE -> IconCreator.createIconFromString("M");
            case SPECIES -> IconCreator.createIconFromString("S");
            case COMPARTMENT -> IconCreator.createIconFromString("C");
            case PARAMETER -> IconCreator.createIconFromString("P");
            case REACTION -> IconCreator.createIconFromString("R");
            case UNIT -> IconCreator.createIconFromString("U");
            default -> IconCreator.createIconFromString("?");
        };
    }
}
