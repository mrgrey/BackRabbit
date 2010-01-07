package com.botland.backrabbit.util;

/**
* Author: Vladimir Batygin
* Date: 07.01.2010
*/
public enum  DIRECTIONS {
    UP(0, -1), DOWN(0, 1), RIGHT(1, 0), LEFT(-1, 0);

    private final int x;
    private final int y;

    DIRECTIONS(final int x, final int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
