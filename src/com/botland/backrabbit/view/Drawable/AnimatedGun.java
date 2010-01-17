package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.GameObject;
import com.botland.backrabbit.model.Gun;
import com.botland.backrabbit.util.Position;

import java.awt.*;

/**
 * Author: Vladimir Batygin
 * Date: 08.01.2010
 */
public class AnimatedGun extends AbstractAnimatedObject {
    private final Gun gun;

    @Override
    public GameObject getGameObject() {
        return gun;
    }

    public AnimatedGun(final Gun gun) {
        super(1);
        this.gun = gun;
    }

    public void paint(final Graphics g) {
        switch (getAnimationState()) {
            case 0:
                g.setColor(Color.MAGENTA);
                break;
            case 1:
                g.setColor(Color.GRAY);
                break;
            default:  //TODO: unnecessary
                g.setColor(Color.BLACK);
                break;
        }
        final Position position = gun.getPosition();
        g.fillRect(position.getX(), position.getY(), gun.getWidth(), gun.getHeight());

        nextFrame();
    }

    @Override
    public boolean changed() {
        return false;
    }

    public Gun getGun() {
        return gun;
    }
}
