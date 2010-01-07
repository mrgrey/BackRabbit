package com.botland.backrabbit.view.Drawable;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractAnimatedInteractableObject extends AbstractAnimatedObject implements Interactable {
    protected AbstractAnimatedInteractableObject(final int animationFramesCount) {
        super(animationFramesCount);
    }

    public void interact(final InteractableAction action) {
        action.perform();
    }
}
