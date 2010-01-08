package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractGameObject implements GameObject {
    protected Position position;
    private int height;
    private int width;

    protected AbstractGameObject(final Position position, int width, int height) {
        this.position = position;
        this.height = height;
        this.width = width;
    }


    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public final int getHeight() {
        return height;
    }

    public final int getWidth() {
        return width;
    }

    public boolean isWall() {
        return false;
    }

    public boolean isApplicable(GameObject object) {
        return false;
    }
}
