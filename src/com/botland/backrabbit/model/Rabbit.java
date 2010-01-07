package com.botland.backrabbit.model;

import com.botland.backrabbit.util.DIRECTIONS;
import com.botland.backrabbit.util.Position;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class Rabbit implements GameObject {

    private final int height = 30;
    private final int width = 30;
    private final int maxJumpHeight = 250;
    private Position position;
    private int alreadyJumped;
    private boolean jumping;
    private boolean falling;

    public Rabbit(final Position position) {
        this.position = position;
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
        return false;
    }

    public boolean isApplicable(final GameObject object) {
        return false;
    }


    public void move(final DIRECTIONS directions, final int game_step) {
        position = new Position(position.getX() + directions.getX() * game_step,
                position.getY() + directions.getY() * game_step);
    }


    public void jump(final int step) {
        if (jumping && alreadyJumped < maxJumpHeight) {
            move(DIRECTIONS.UP, step);
            alreadyJumped += step;
        } else {
            alreadyJumped = 0;
            jumping = false;
        }
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(final boolean b) {
        jumping = b;
        if (!b) {
            alreadyJumped = 0;
        }
    }


    public boolean isFalling() {
        return falling;
    }

    public void setFalling(final boolean b) {
        falling = b;
    }
}
