package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-06-28.
 */
public class PullPlanet extends Planet {
    public PullPlanet(World world, Vector2 pos, int magneticRange, float width, float height) {
        super(world, Assets.pullPlanetFieldActiveAnimation, pos, magneticRange, width, height);
    } //base : no active
}
