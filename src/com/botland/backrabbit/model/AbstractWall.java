package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 08.01.2010
 */
public abstract class AbstractWall extends AbstractGameObject implements Wall {
    protected AbstractWall(final Position position, int width, int height) {
        super(position, width, height);
    }

    @Override
    public boolean isWall() {
        return true;
    }
}
