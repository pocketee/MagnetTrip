package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-07-16.
 */
public class PushPlanet extends Planet{
    public PushPlanet(World world, Vector2 pos, int magneticRange, float width, float height) {
        super(world, Assets.pushPlanetFieldActiveAnimation, pos, magneticRange, width, height);
    }
}
