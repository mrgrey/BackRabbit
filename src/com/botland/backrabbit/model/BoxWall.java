package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class BoxWall implements Wall {

    private final Position position;
    private final int height;
    private final int width;

    public BoxWall(final Position position, final int width, final int height) {
        this.position = position;
        this.height = height;
        this.width = width;
    }

    public Position getPosition() {
        return position;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWall() {
        return true;
    }

    public boolean isApplicable(final GameObject object) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
