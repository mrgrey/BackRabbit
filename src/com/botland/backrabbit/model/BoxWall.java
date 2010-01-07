package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

/**
 * Author: Vladimir Batygin
 * Date: 07.01.2010
 */
public class BoxWall extends AbstractWall {

    public BoxWall(final Position position, final int width, final int height) {
        super(position);
        this.height = height;
        this.width = width;
    }
}
