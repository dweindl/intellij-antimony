package com.github.dweindl.intellijAntimony;

// import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.IconLoader;
import java.awt.Color;

import javax.swing.*;

public class AntimonyIcons {
    public static final Icon FILE = IconLoader.getIcon("/icons/antimonyFileIcon.svg", AntimonyIcons.class);
    // public static final Icon FILE = AllIcons.Actions.ArrowExpand;

    public static Icon getIcon(AntimonyUtil.ModelEntity type) {
        return switch (type) {
            case MODULE -> IconCreator.createIconFromString("M", Color.decode("#F26522"));
            case SPECIES -> IconCreator.createIconFromString("S", Color.decode("#F4AF3D"));
            case COMPARTMENT -> IconCreator.createIconFromString("C", Color.decode("#40B6E0"));
            case PARAMETER -> IconCreator.createIconFromString("P", Color.decode("#B99BF8"));
            case REACTION -> IconCreator.createIconFromString("R", Color.decode("#9AA7B0"));
            case UNIT -> IconCreator.createIconFromString("U", Color.decode("#A4C639"));
            default -> IconCreator.createIconFromString("?", null);
        };
    }
}
