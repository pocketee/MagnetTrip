package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.harry.MagnetTrip.Assets;

/**
 * Created by jh on 2014-07-06.
 */
public class Car extends Box2dActor {
    private static final float CAR_VELOCITY = 2.0f;
    public Car(World world, Vector2 pos, float width, float height) {
        super(world, Assets.forwardCarAnimation, pos, BodyDef.BodyType.DynamicBody, width, height);
        makeRectFixture(width, height, 1f, 0.1f);
        setTouchable(Touchable.enabled);

        body.setLinearVelocity(new Vector2(1.5f, 0));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        body.setTransform(body.getPosition(), MathUtils.degreesToRadians * body.getLinearVelocity().angle());
    }
}
