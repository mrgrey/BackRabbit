package com.botland.backrabbit.view;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class RabbitComponent {

    public final int MAX_JUMP_HEIGHT = 250; 

    private int x;
    private int y;

    public void paint(final Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 30);
    }


}
