package com.botland.backrabbit.view.Drawable;

import com.botland.backrabbit.model.GameObject;
import com.botland.backrabbit.model.Rabbit;
import com.botland.backrabbit.model.RabbitState;
import com.botland.backrabbit.util.Position;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class AnimatedRabbit extends AbstractAnimatedObject {

    public final Rabbit rabbit;

    public final List<Image> images;

    @Override
    public GameObject getGameObject() {
        return rabbit;
    }

    public AnimatedRabbit(final Rabbit rabbit, List<Image> imageList) {
        super(1);
        images = imageList;
        this.rabbit = rabbit;
    }

    public void paint(final Graphics g) {
        final Image image;
        if (rabbit.isMove() && rabbit.getState() == RabbitState.STOP) {
            image = changeImage();
        } else {
            image = images.get(0);
        }
        final Position pos = rabbit.getPosition();
        g.drawImage(image, pos.getX(), pos.getY(), rabbit.getWidth(), rabbit.getHeight(), this);
    }

    private Image changeImage() {
        final int size = images.size();
        final int i = getCurTime() % size;
        return images.get(i);
    }

    @Override
    public boolean changed() {
        return rabbit.isMove() || rabbit.getState() != RabbitState.STOP || rabbit.getLastactioned();
    }

    public Rabbit getRabbit() {
        return rabbit;
    }
}
