package com.botland.backrabbit.view.Drawable;

import javax.swing.*;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractAnimatedObject extends JComponent {
    int animationFramesCount;
    long currentFrame = 0;

    protected AbstractAnimatedObject(final int animationFramesCount) {
        this.animationFramesCount = animationFramesCount;
    }

    protected void nextFrame() {
        //TODO: Handle overflow
        currentFrame++;
    }

    protected int getAnimationState() {
        return (int) (currentFrame % animationFramesCount);
    }
}
