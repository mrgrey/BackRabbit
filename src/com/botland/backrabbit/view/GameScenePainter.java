package com.botland.backrabbit.view;

import com.botland.backrabbit.view.Drawable.AbstractAnimatedObject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class GameScenePainter {

    private final List<AbstractAnimatedObject> components;

    public GameScenePainter(final List<AbstractAnimatedObject> components) {
        this.components = components;
    }


    public void paint(Graphics g) {
        paintBackground(g);
        for (final JComponent component : components) {
            component.paint(g);
        }
    }

    private void paintBackground(final Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 600);

    }

    public boolean needRepaint() {
        boolean flag = false;

        // this is small hack, don't refactor or refactor carefully
        for (AbstractAnimatedObject component : components) {
            if (component.changed()) {
                flag = true;
            }
        }
        return flag;
    }

}
