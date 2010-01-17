package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class Rabbit extends AbstractGameObject {

    private final int maxJumpHeight = 250;
    private int alreadyJumped;
    private RabbitState state;
    private Directions flyDirection;

    public Rabbit(final Position position) {
        super(position, 30, 30);
    }

    public void move(final Directions directions, final int game_step) {
        position = new Position(position.getX() + directions.getX() * game_step,
                position.getY() + directions.getY() * game_step);
    }


    public void jump(final int step) {
        if (state == RabbitState.JUMP && alreadyJumped < maxJumpHeight) {
            move(Directions.UP, step);
            alreadyJumped += step;
        } else {
            alreadyJumped = 0;
            state = RabbitState.FALLING;
        }
    }

    public RabbitState getState() {
        return state;
    }

    public void setState(final RabbitState state) {
        this.state = state;
        if (state != RabbitState.JUMP) {
            alreadyJumped = 0;
        }
    }

    public void fly(final Directions direction) {
        state = RabbitState.FLY;
        flyDirection = direction;
    }

    public Directions getFlyDirection() {
        return flyDirection;
    }

}
