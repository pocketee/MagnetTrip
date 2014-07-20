package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-07-20.
 */
public class BasicWall extends Box2dActor implements ForceObstacle {
    public BasicWall(World world, Vector2 pos, float width, float height) {
        super(world, Assets.basicWallAnimation, pos, BodyDef.BodyType.StaticBody, width, height);
        makeRectFixture(width, height, 1, 0);
        setTouchable(Touchable.enabled);
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
        if(getCenterX() < standard) {
            return true;
        }
        return false;
    }
}
