package com.github.dweindl.intellijantimony;

import com.intellij.ui.JBColor;
import com.intellij.util.ui.ImageUtil;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconCreator {

    public Icon createIconFromString(String text) {
        int width = 16;
        int height = 16;

        // Create an image
        Image image = ImageUtil.createImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        // Set the font and color
        Font font = JBUI.Fonts.create(Font.SANS_SERIF, 10);
        g.setFont(font);
        g.setColor(JBColor.BLACK);

        // Draw the text onto the image
        g.drawString(text, 0, g.getFontMetrics().getAscent());

        // Create an icon from the image
        return new ImageIcon(image);
    }
}