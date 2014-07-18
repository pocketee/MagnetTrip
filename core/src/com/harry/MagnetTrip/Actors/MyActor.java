package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by jh on 2014-07-13.
 */
public class MyActor extends Actor {
    //Actor related variable
    float width;
    float height;

    TextureRegion currentFrame;
    protected Animation animation;
    protected float stateTime;

    public MyActor() {
        super();
    }

    public MyActor(Animation animation, Vector2 pos, float width, float height) {
        this.animation = animation;
        this.width = width;
        this.height = height;
        setX(pos.x); setY(pos.y);

        stateTime = 0f;

        setOrigin(width/2, height/2);
        setWidth(width);
        setHeight(height);
        setBounds(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime, true);

        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(),
                getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void destroy() {
        this.addAction(Actions.removeActor());
    }


    public void setCenterX(float x) { setX(x - getWidth() / 2); }
    public float getCenterX() { return getX() + getWidth()/2; }
    public void setCenterY(float y) { setY(y-getHeight()/2); }
    public float getCenterY() { return getY() + getHeight()/2; }
}
