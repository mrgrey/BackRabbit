package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public interface GameObject {

    Position getPosition();

    int getHeight();

    int getWidth();

    boolean isWall();

    boolean isApplicable(GameObject object);
}
