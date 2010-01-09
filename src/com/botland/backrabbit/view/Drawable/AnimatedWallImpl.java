package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.GameObject;

import java.awt.*;

/**
 * Author: Vladimir Batygin
 * Date: 09.01.2010
 */
public class AnimatedWallImpl extends AnimatedWall {
    public AnimatedWallImpl(GameObject wall, Image image) {
        super(wall, image);
    }

    @Override
    public void paint(final Graphics g) {
        g.drawImage(image, wall.getPosition().getX(), wall.getPosition().getY(),
                wall.getWidth(), wall.getHeight(), this);
    }
}
