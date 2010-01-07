package com.botland.backrabbit.view;

import com.botland.backrabbit.model.GameScene;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class GameScenePainter {

    private final List<JComponent> components;

    public GameScenePainter(final List<JComponent> components) {
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

}
