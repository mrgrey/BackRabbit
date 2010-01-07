package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.Teleport;
import com.botland.backrabbit.util.Position;

import java.awt.*;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class AnimatedTeleport extends AbstractAnimatedObject {
    private final Teleport teleport;
    public AnimatedTeleport(Teleport teleport) {
        super(2);

        this.teleport = teleport;
    }

    public Teleport getTeleport() {
        return teleport;
    }

    public void paint(final Graphics g) {
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
        final Position position = teleport.getPosition();
        g.fillRect(position.getX(),position.getY(),teleport.getWidth(),teleport.getHeight());

        nextFrame();
    }
}
