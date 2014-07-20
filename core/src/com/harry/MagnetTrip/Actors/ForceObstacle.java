package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by jh on 2014-07-20.
 */
public interface ForceObstacle {
    public void applyForceToCar(Body carBody);
    public boolean isActive();
    public void setActive(boolean isActive);
    public boolean lessThanFloat(float standard);
}
