package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Directions;
import com.botland.backrabbit.util.Position;

import java.util.List;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class GameScene {

    private final int GAME_STEP = 4;

    private final List<GameObject> gameObjects;
    private final Rabbit rabbit;
    private static final int JUMP_MULTIPLIER = 3;


    public GameScene(final List<GameObject> gameObjects, final Rabbit rabbit) {
        this.gameObjects = gameObjects;
        this.rabbit = rabbit;
    }

    public void moveRabbit(final Directions directions) {
        if (!hasWalls(directions)) {
            rabbit.move(directions, GAME_STEP);
        }
    }

    private boolean hasWalls(final Directions direction, int multiplier) {
        return hasWalls(direction, GAME_STEP, multiplier);
    }

    private boolean hasWalls(final Directions direction, int step, int multiplier) {
        for (final GameObject gameObject : gameObjects) {
            if (gameObject.isWall()) {
                if (hasWall(gameObject, direction, step, multiplier)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasWall(final GameObject gameObject, Directions directions, final int step, final int multiplier) {
        final Position position = new Position(rabbit.getPosition().getX() + directions.getX() * step * multiplier,
                rabbit.getPosition().getY() + directions.getY() * step * multiplier);
        return     inCube(position.getX(), position.getY(), gameObject)
                || inCube(position.getX() + rabbit.getWidth(), position.getY(), gameObject)
                || inCube(position.getX(), position.getY() + rabbit.getHeight(), gameObject)
                || inCube(position.getX() + rabbit.getWidth(), position.getY() + rabbit.getHeight(), gameObject);
    }

    private boolean inCube(final int x, final int y, final GameObject gameObject) {
        final Position pos = gameObject.getPosition();
        return x >= pos.getX() && x <= pos.getX() + gameObject.getWidth() &&
                y >= pos.getY() && y <= pos.getY() + gameObject.getHeight();
    }

    public void setRabbitJump() {
        if (!rabbit.isFalling()) {
            rabbit.setJumping();
        }

    }

    public void doActions() {
        if (rabbit.isFly()) {
            if (!hasWalls(rabbit.getFlyDirection(), GAME_STEP * 2)) {
                rabbit.move(rabbit.getFlyDirection(), GAME_STEP * 2);
            } else {
                proceedToWall(rabbit.getFlyDirection(), GAME_STEP * 2);
                rabbit.setGeneral();
            }
        } else if (!hasWalls(Directions.DOWN) && !rabbit.isJumping()) {
            rabbit.move(Directions.DOWN, GAME_STEP);
            proceedToWall(Directions.DOWN, GAME_STEP);
            rabbit.setFalling();
        } else if (rabbit.isJumping()) {
            if (hasWalls(Directions.UP, JUMP_MULTIPLIER)) {
                proceedToWall(Directions.UP, GAME_STEP * 4);
                rabbit.setFalling();
            } else {
                rabbit.jump(JUMP_MULTIPLIER * GAME_STEP);
               // rabbit.setJumping();
            }
        } else {
            rabbit.setGeneral();
        }
        for(final GameObject gameObject : gameObjects) {
            if(gameObject.isApplicable(rabbit)) {
                ((Applicable)gameObject).doPositionValidatedAction(rabbit);
                if(!isValidRabbitPosition()) {
                    ((Applicable)gameObject).rollback(rabbit);    
                }
                break;
            }
        }
    }

    private boolean hasWalls(final Directions up) {
       return hasWalls(up, 1);
    }

   
    private boolean isValidRabbitPosition() {
        for(final GameObject gameObject : gameObjects) {
            if(gameObject instanceof Wall && isInersect(gameObject, rabbit)) {
                return false;
            }
        }
        return true;
    }

    private boolean isInersect(final GameObject first, final GameObject second) {
        return false; //TODO: fix me
    }

    private void proceedToWall(Directions direction, int limit) {
        for(int pixelsToWall = 1; pixelsToWall <= limit + 10; pixelsToWall++) {
            if(hasWalls(direction, 1, pixelsToWall)) {
                rabbit.move(direction, pixelsToWall-1);
                return;
            }
        }
    }
}
