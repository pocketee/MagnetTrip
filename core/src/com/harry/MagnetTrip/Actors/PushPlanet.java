package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-07-16.
 */
public class PushPlanet extends Planet {
    public PushPlanet(World world, Vector2 pos, int magneticRange, float width, float height) {
        super(world, Assets.pushPlanetFieldActiveAnimation, pos, magneticRange, width, height);
    }

    @Override
    public void applyForceToCar(Body carBody) {
        CircleShape magnetShape = (CircleShape) getBody().getFixtureList().get(0).getShape();
        float magnetRadius = magnetShape.getRadius();
        Vector2 magnetPosition = getBody().getWorldCenter();
        Vector2 magnetDistance = new Vector2(0, 0);

        magnetDistance.add(magnetPosition);
        magnetDistance.sub(carBody.getWorldCenter());
        float finalDistance = magnetDistance.len();


        if (finalDistance <= getMagnetPower() * magnetRadius) {
            float factor = carBody.getMass() / finalDistance / finalDistance * getMagnetPower() / 2.5f ;

            magnetDistance.scl(factor);
            carBody.applyForce(magnetDistance, carBody.getWorldCenter(), true);
        }
    }
}
