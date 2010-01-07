package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;
import com.botland.backrabbit.view.Drawable.InteractableAction;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractApplicableObject extends AbstractGameObject {
    protected AbstractApplicableObject(final Position position) {
        super(position);
    }

    abstract InteractableAction getAction(GameObject object);
}
