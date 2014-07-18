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
 * Created by jh on 2014-05-13.
 */
public class Box2dActor extends MyActor {
    //Actor related variable
    float width;
    float height;

    TextureRegion currentFrame;
    protected Animation animation;
    protected float stateTime;

    //Box2d related variable
    static final float WORLD_TO_BOX=0.01f;
    static final float BOX_TO_WORLD=100f;

    protected Body body;
    protected Vector2 worldPosition;
    protected World world;

    public Box2dActor(World world, Animation animation, Vector2 pos, BodyDef.BodyType bodyType, float width, float height) {
        super(animation, pos, width, height);

        this.world = world;
        worldPosition=new Vector2();
        createBody(world, pos, bodyType, 0);
        body.setUserData(this);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        updateWorldPosition();
        setCenterX(worldPosition.x); setCenterY(worldPosition.y);
        setRotation(body.getAngle() * MathUtils.radiansToDegrees);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }


    //Box2d related
    public void createBody(World world, Vector2 pos, BodyDef.BodyType bodyType, float angle){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = bodyType;
        bodyDef.position.set(convertToBox(pos.x), convertToBox(pos.y));
        bodyDef.angle=angle;
        body = world.createBody(bodyDef);
    }

    public void makeRectFixture(float width, float height, float density, float restitution){
        PolygonShape bodyShape = new PolygonShape();

        float w= convertToBox(width / 2f);
        float h= convertToBox(height / 2f);
        bodyShape.setAsBox(w, h);

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.density=density;
        fixtureDef.restitution=restitution;
        fixtureDef.friction = 1;
        fixtureDef.shape=bodyShape;

        body.createFixture(fixtureDef);
        bodyShape.dispose();
    }

    public void makeCircleFixture(float radius, float density, float restitution){
        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.density=density;
        fixtureDef.restitution=restitution;
        fixtureDef.shape=new CircleShape();
        fixtureDef.shape.setRadius(convertToBox(radius));

        body.createFixture(fixtureDef);
        fixtureDef.shape.dispose();
    }

    @Override
    public void destroy() {
        world.destroyBody(body);
        super.destroy();
    }

    //getter and setter
    public Body getBody() {
        return body;
    }

    private float convertToBox(float x){ //pixel to meter 지금은 테스트중이라 상수 안 곱함
        return x*WORLD_TO_BOX;
        //return x;
    }
    private float convertToWorld(float x){ //meter to pixel
        return x*BOX_TO_WORLD;
        //return x;
    }
    private void updateWorldPosition(){
        worldPosition.set(convertToWorld(body.getPosition().x), convertToWorld(body.getPosition().y));
    }
}
