package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by jh on 2014-07-20.
 */
public class Wall extends Box2dActor implements ForceObstacle {
    public Wall(World world, Animation animation, Vector2 pos, BodyDef.BodyType bodyType, float width, float height) {
        super(world, animation, pos, bodyType, width, height);
    }

    @Override
    public void applyForceToCar(Body carBody) {

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setActive(boolean isActive) {

    }

    @Override
    public boolean lessThanFloat(float standard) {
        return false;
    }
}
