package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractAnimatedObject extends JComponent {
    int animationFramesCount;
    long currentFrame = 0;
    private boolean painted;
    private static int i = 0;

    public final static Timer timer = new Timer(50, new AbstractAction() {

        public void actionPerformed(final ActionEvent e) {
            if (i >= 63) {
                i =0;
            } else {
                i ++;
            }
        }
    });

    public static int getCurTime() {
        return i;
    }

    protected AbstractAnimatedObject(final int animationFramesCount) {
        this.animationFramesCount = animationFramesCount;
    }

    protected void nextFrame() {
        //TODO: Handle overflow
        currentFrame++;
    }

    @Override
    public abstract void paint(final Graphics g);

    public abstract boolean changed(); 

    protected int getAnimationState() {
        return (int) (currentFrame % animationFramesCount);
    }

    public abstract GameObject getGameObject();
}
