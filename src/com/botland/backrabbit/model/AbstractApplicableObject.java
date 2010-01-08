package com.botland.backrabbit.model;

import com.botland.backrabbit.util.Position;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Yury Chuyko aka mrgrey
 * Date: 07.01.2010
 */
public abstract class AbstractApplicableObject extends AbstractGameObject implements Applicable {
    private Map<GameObject, Position> backupPositions = new HashMap<GameObject, Position>();

    protected AbstractApplicableObject(final Position position, int width, int height) {
        super(position, width, height);
    }

    public void doPositionValidatedAction(final GameObject target) {
        if(backupPositions.containsKey(target)) {
            backupPositions.remove(target);
        }
        backupPositions.put(target, Position.fromPosition(target.getPosition()));
        getAction(target).perform();
    }

    public void rollback(GameObject target) {
        if(!backupPositions.containsKey(target)) {
            throw new RuntimeException("Can't rollback! Sorry! :(");
        }
        target.setPosition(backupPositions.remove(target));
    }
}
