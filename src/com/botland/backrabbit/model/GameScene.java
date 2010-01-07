package com.botland.backrabbit.model;

import com.botland.backrabbit.util.DIRECTIONS;
import com.botland.backrabbit.util.Position;

import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class GameScene {

    private final int GAME_STEP = JUMP_MULTIPLIER;

    private final List<GameObject> gameObjects;
    private final Rabbit rabbit;
    private static final int JUMP_MULTIPLIER = 4;


    public GameScene(final List<GameObject> walls, final Rabbit rabbit) {
        this.gameObjects = walls;
        this.rabbit = rabbit;
    }

    public void moveRabbit(final DIRECTIONS directions) {
        if (!hasWalls(directions)) {
            rabbit.move(directions, GAME_STEP);
        }
    }

    private boolean hasWalls(final DIRECTIONS direction, int multiplier) {
        for (final GameObject gameObject : gameObjects) {
            if (gameObject.isWall()) {
                if (hasWall(gameObject, direction, multiplier)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean hasWall(final GameObject gameObject, DIRECTIONS directions, final int multiplier) {
        final Position position = new Position(rabbit.getPosition().getX() + directions.getX() * GAME_STEP * multiplier,
                rabbit.getPosition().getY() + directions.getY() * GAME_STEP * multiplier);
        return inCube(position.getX(), position.getY(), gameObject)
                || inCube(position.getX() + rabbit.getWidth(), position.getY(), gameObject)
                || inCube(position.getX(), position.getY() + rabbit.getHeight(), gameObject)
                || inCube(position.getX() + rabbit.getWidth(), position.getY() + rabbit.getHeight(), gameObject);
    }

    private boolean inCube(final int x, final int y, final GameObject gameObject) {
        final Position pos = gameObject.getPosition();
        return x > pos.getX() && x < pos.getX() + gameObject.getWidth() &&
                y > pos.getY() && y < pos.getY() + gameObject.getHeight();
    }


    public void setRabbitJump(boolean b) {
        if (!rabbit.isFalling()) {
            rabbit.setJumping(b);
        }

    }

    public void doActions() {
        if (!hasWalls(DIRECTIONS.DOWN) && !rabbit.isJumping()) {
            rabbit.move(DIRECTIONS.DOWN, GAME_STEP);
            rabbit.setFalling(true);
            rabbit.setJumping(false);
        } else if (rabbit.isJumping()) {
            if (hasWalls(DIRECTIONS.UP, JUMP_MULTIPLIER)) {
                rabbit.setJumping(false);
            } else {
                rabbit.jump(JUMP_MULTIPLIER * GAME_STEP);
                rabbit.setFalling(!rabbit.isJumping());
            }
        } else {
            rabbit.setFalling(false);
        }
    }

    private boolean hasWalls(final DIRECTIONS up) {
       return hasWalls(up, 1);
    }
}