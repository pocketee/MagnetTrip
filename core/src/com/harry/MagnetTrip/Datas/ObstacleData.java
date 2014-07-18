package com.harry.MagnetTrip.Datas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;

/**
 * Created by jh on 2014-07-10.
 */
public class ObstacleData {
    public final static int PULL_PLANET = 1;
    public final static int PUSH_PLANET = 2;

    protected int obstacleType;
    protected Vector2 pos;
    protected int magneticRange;
    protected float width;
    protected float height;

    public  ObstacleData() {

    }

    public ObstacleData(int obstacleType, Vector2 pos, int magneticRange, float width, float height) {
        this.setDatas(obstacleType, pos, magneticRange, width, height);
    }





    //getter and setter
    protected void setDatas(int obstacleType, Vector2 pos, int magneticRange, float width, float height) {
        this.setObstacleType(obstacleType);
        this.setPos(pos);
        this.setMagneticRange(magneticRange);
        this.setWidth(width);
        this.setHeight(height);
    }

    public int getMagneticRange() {
        return magneticRange;
    }

    public void setMagneticRange(int magneticRange) {
        this.magneticRange = magneticRange;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Vector2 getPos() {
        return pos.cpy();
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public int getObstacleType() {
        return obstacleType;
    }

    public void setObstacleType(int obstacleType) {
        this.obstacleType = obstacleType;
    }

    @Override
    public String toString() {
        return "x = " + pos.x;
    }
}
