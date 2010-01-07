package com.botland.backrabbit.util;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class Position {

    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position fromPosition(final Position position) {
        return new Position(position.getX(), position.getY());
    }
}
