package com.botland.backrabbit.view.Drawable;

import java.awt.*;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class AnimatedRabbit extends AbstractAnimatedObject {

    public final int MAX_JUMP_HEIGHT = 250;

    public AnimatedRabbit() {
        super(2);
    }

    public void paint(final Graphics g, final int x, final int y) {
        switch (getAnimationState()) {
            case 0:
                g.setColor(Color.RED);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
            default:  //TODO: unnecessary
                g.setColor(Color.BLACK);
                break;
        }
        g.fillOval(x, y, 30, 30);
        nextFrame();
    }
}
