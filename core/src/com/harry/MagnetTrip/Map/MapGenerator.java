package com.harry.MagnetTrip.Map;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.harry.MagnetTrip.Actors.BasicWall;
import com.harry.MagnetTrip.Actors.PullPlanet;
import com.harry.MagnetTrip.Actors.MyActor;
import com.harry.MagnetTrip.Actors.PushPlanet;
import com.harry.MagnetTrip.Assets;
import com.harry.MagnetTrip.Datas.MapPiece;
import com.harry.MagnetTrip.Datas.ObstacleData;
import com.harry.MagnetTrip.Json.MapPiecesFileReader;
import com.harry.MagnetTrip.World.GameWorld;

import java.util.Random;

/**
 * Created by jh on 2014-07-11.
 */
public class MapGenerator {
    protected int maxNumtoStay; //유지할 맵의 최대 갯수
    protected MapPiecesFileReader reader;
    protected GameWorld gameWorld;
    protected World world;
    protected float mapCount; //생성한 맵 개수

    public MapGenerator(GameWorld gameWorld, String filePath, int maxNumtoStay) {
        this.maxNumtoStay = maxNumtoStay;
        this.gameWorld = gameWorld;
        world = gameWorld.getWorld();
        FileHandle file = Gdx.files.internal(filePath);
        reader = new MapPiecesFileReader(file);
        mapCount=0;
    }

    public void addMapPieceToWorld() {
        Random random = new Random();
        int randomInt = random.nextInt(reader.size());
        Gdx.app.log("MapGenerator", "random = " + randomInt);
        addMapPieceToWorld(randomInt);
    }

    public void addMapPieceToWorld(int index) {
        MapPiece mapPiece = reader.get(index); //여기 랜덤함수로 바꾸기

        for (int i=0; i< mapPiece.size(); i++) {
            ObstacleData data;
            data = mapPiece.get(i);

            switch (data.getObstacleType()) {
                case ObstacleData.PULL_PLANET:
                    gameWorld.addObstacle(new PullPlanet(world, data.getPos().add(mapCount * gameWorld.getDisplayWidth(), 0), data.getMagneticRange(), data.getWidth(), data.getHeight()));
                    break;
                case ObstacleData.PUSH_PLANET:
                    gameWorld.addObstacle(new PushPlanet(world, data.getPos().add(mapCount * gameWorld.getDisplayWidth(), 0), data.getMagneticRange(), data.getWidth(), data.getHeight()));
                    break;
                case ObstacleData.BASIC_WALL:
                    gameWorld.addObstacle(new BasicWall(world, data.getPos().add(mapCount * gameWorld.getDisplayWidth(), 0), data.getWidth(), data.getHeight()));
                    break;
            }
        }

        addBackgroundToWorld();
    }

    public void addBackgroundToWorld() {
        gameWorld.addBackground(new MyActor(Assets.mapAnimation, new Vector2(mapCount * gameWorld.getDisplayWidth() -100, 0), gameWorld.getDisplayWidth(), gameWorld.getDisplayHeight()));
        mapCount++;
    }

    //getter and setter
    public float getMapCount() {
        return mapCount;
    }

    public int getMaxNumtoStay() {
        return maxNumtoStay;
    }
}
