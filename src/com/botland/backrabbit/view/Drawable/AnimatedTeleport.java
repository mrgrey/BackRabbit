package com.botland.backrabbit.view.Drawable;

import java.awt.*;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class AnimatedTeleport extends AbstractAnimatedInteractableObject {
    public AnimatedTeleport() {
        super(2);
    }

    public void paint(final Graphics g, final int x, final int y) {
        switch (getAnimationState()) {
            case 0:
                g.setColor(Color.BLUE);
                break;
            case 1:
                g.setColor(Color.CYAN);
                break;
            default:  //TODO: unnecessary
                g.setColor(Color.BLACK);
                break;
        }
        g.fillRect(x,y,30,30);
        nextFrame();
    }
}
