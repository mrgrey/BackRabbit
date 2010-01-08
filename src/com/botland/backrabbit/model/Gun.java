package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.InteractableAction;

/**
 * Author: Vladimir Batygin
 * Date: 08.01.2010
 */
public class Gun extends AbstractApplicableObject implements Wall {

    private final static int DELTA = 5;

    private final Directions direction;

    public Gun(final Position position, Directions direction) {
        super(position, 30, 30);
        this.direction = direction;
    }

    public InteractableAction getAction(final GameObject target) {
        return new InteractableAction(){

            public void perform() {
                ((Rabbit) target).fly(direction);
            }
        };
    }

    @Override
    public boolean isApplicable(final GameObject object) {
        final int diffX = object.getPosition().getX() - position.getX();
        final int diffY = object.getPosition().getY() - position.getY();
        switch (direction) {
            case UP:
                return Math.abs(diffX) < getWidth() /2
                        && diffY + object.getHeight()< DELTA;
            case DOWN:
                return Math.abs(diffX) < getWidth() /2
                        && diffY - getHeight()< DELTA;
            case RIGHT:
                return Math.abs(diffX - getWidth()) < DELTA
                        && diffY < getHeight() /2;
            case LEFT:
                return Math.abs(diffX + object.getWidth()) < DELTA
                        && diffY < getHeight() / 2;
        }
        return false;

    }

    @Override
    public boolean isWall() {
        return true;
    }
}
