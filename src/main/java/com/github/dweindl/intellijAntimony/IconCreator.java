package com.github.dweindl.intellijAntimony;

import com.intellij.ui.JBColor;
import com.intellij.util.ui.ImageUtil;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconCreator {

    public static Icon createIconFromString(String text, Color backgroundColor) {
        int width = 16;
        int height = 16;

        // Create an image
        Image image = ImageUtil.createImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) image.getGraphics();

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(backgroundColor != null) {
            g.setColor(backgroundColor);
            g.drawOval(0, 0, width - 1, height - 1);
        }

        // Set the font and color
        Font font = JBUI.Fonts.create(Font.SANS_SERIF, 10);
        g.setFont(font);
        g.setColor(JBColor.BLACK);

        // Calculate the width and height of the text
        FontMetrics fm = g.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        // Calculate the x and y coordinates where the text should be drawn
        int x = (width - textWidth) / 2;
        int y = (height - textHeight) / 2 + fm.getAscent() + 1;

        // Draw the text onto the image
        g.drawString(text, x, y);

        return new ImageIcon(image);
    }
}