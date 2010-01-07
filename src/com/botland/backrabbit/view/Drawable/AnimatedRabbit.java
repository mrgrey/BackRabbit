package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.Rabbit;
import com.botland.backrabbit.util.Position;

import java.awt.*;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class AnimatedRabbit extends AbstractAnimatedObject {

    public final Rabbit rabbit;

    public AnimatedRabbit(final Rabbit rabbit) {
        super(2);
        this.rabbit = rabbit;
    }

    public void paint(final Graphics g) {
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
        final Position pos = rabbit.getPosition();
        g.fillOval(pos.getX(), pos.getY(), rabbit.getWidth(), rabbit.getHeight());
        nextFrame();
    }

    public void paint(final Graphics g, final int x, final int y) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public Rabbit getRabbit() {
        return rabbit;
    }
}
