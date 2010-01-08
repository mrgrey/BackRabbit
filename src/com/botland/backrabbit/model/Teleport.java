package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.InteractableAction;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public class Teleport extends AbstractApplicableObject {
    private final int DELTA = 5;
    private Position targetPosition;

    public Teleport(final Position position, final Position targetPosition) {
        super(position, 30, 30);
        this.targetPosition = targetPosition;
    }

    public InteractableAction getAction(final GameObject object) {
        if(!isApplicable(object)) {
            return new InteractableAction() {
                public void perform() {
                    //do nothing
                }
            };
        }
        return new InteractableAction() {
            public void perform() {
                object.setPosition(Position.fromPosition(targetPosition));
            }
        };
    }

    @Override
    public boolean isApplicable(final GameObject object) {
        return object instanceof Rabbit && isTouchApplicable(object);
    }


    private boolean isTouchApplicable(final GameObject rabbit) {
           //TODO: fix to TOUCH, not being in
           final Position rabbitPosition = rabbit.getPosition();
           final Position objectPosition = getPosition();
           return Math.abs(rabbitPosition.getX() - objectPosition.getX()) <= DELTA &&
                   Math.abs(rabbitPosition.getY() - objectPosition.getY()) <= DELTA;
       }

}
