package com.botland.backrabbit.model;

import com.botland.backrabbit.util.DIRECTIONS;
import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.InteractableAction;

/**
 * Author: Vladimir Batygin
 * Date: 08.01.2010
 */
public class Gun extends AbstractApplicableObject {
    private final DIRECTIONS direction;

    protected Gun(final Position position, DIRECTIONS direction) {
        super(position);
        this.direction = direction;
    }

    public InteractableAction getAction(final GameObject target) {
        return new InteractableAction(){

            public void perform() {
                ((Rabbit) target).fly(direction);
            }
        };
    }

    @Override
    public boolean isApplicable(final GameObject object) {
        return super.isApplicable(object);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
