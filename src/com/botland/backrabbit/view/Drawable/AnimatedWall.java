package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.Wall;
import com.botland.backrabbit.util.Position;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class AnimatedWall extends AbstractAnimatedObject {
    private final Wall wall;
    private final Image image;

    public AnimatedWall(Wall wall, Image image) {
        super(1);

        this.wall = wall;
        this.image = image;
    }


    @Override
    public void paint(final Graphics g) {
        //  g.drawImage(image, wall.getPosition().getX(), wall.getPosition().getY(), this);
        drawImagesInRect(g, image);
        //  g.setColor(Color.BLACK);
        g.setColor(Color.GREEN);
        g.drawRect(wall.getPosition().getX(), wall.getPosition().getY(), wall.getWidth(), wall.getHeight());
    }

    public Wall getWall() {
        return wall;
    }

    public void drawImagesInRect(Graphics g, Image image) {
        final Position pos = wall.getPosition();
        for (int i = pos.getX(); i < pos.getX() + wall.getWidth(); i += image.getWidth(this)) {
            for (int j = pos.getY(); j < pos.getY() + wall.getHeight(); j += image.getHeight(this)) {
                g.drawImage(image, i, j, this);
            }
        }

    }


}
