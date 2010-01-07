package com.botland.backrabbit.model;

import com.botland.backrabbit.view.Drawable.InteractableAction;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 08.01.2010
 */
public interface Applicable {
    InteractableAction getAction(GameObject target);
    void doPositionValidatedAction(GameObject target);
    void rollback(GameObject target);
}
