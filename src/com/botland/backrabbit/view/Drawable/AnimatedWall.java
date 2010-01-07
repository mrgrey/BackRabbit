package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.Wall;
import com.botland.backrabbit.util.Position;

import java.awt.*;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class AnimatedWall extends AbstractAnimatedObject {
    private final Wall wall;

    public AnimatedWall(Wall wall) {
        super(1);

        this.wall = wall;
    }


    @Override
    public void paint(final Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(wall.getPosition().getX(), wall.getPosition().getY(), wall.getWidth(), wall.getHeight());
    }

    public Wall getWall() {
        return wall;
    }
}
