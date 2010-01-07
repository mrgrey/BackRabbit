package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractGameObject implements GameObject {
    protected Position position;
    protected int height;
    protected int width;

    protected AbstractGameObject(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWall() {
        return false;
    }

    public boolean isApplicable(GameObject object) {
        return false;
    }
}
