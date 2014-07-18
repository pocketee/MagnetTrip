package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-07-06.
 */
public class Wall extends Box2dActor {
    public Wall(World world, Vector2 pos, float width, float height) {
        super(world, Assets.forwardCarAnimation, pos, BodyDef.BodyType.StaticBody, width, height);
        makeRectFixture(width, height, 1, 0);
        setTouchable(Touchable.enabled);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
