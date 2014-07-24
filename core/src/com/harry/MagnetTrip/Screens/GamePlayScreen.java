package com.harry.MagnetTrip.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.harry.MagnetTrip.Datas.MapPiece;
import com.harry.MagnetTrip.Datas.ObstacleData;
import com.harry.MagnetTrip.Json.MapPieceFileWriter;
import com.harry.MagnetTrip.Json.MapPiecesFileReader;
import com.harry.MagnetTrip.MagnetTrip;
import com.harry.MagnetTrip.World.GameWorld;

/**
 * Created by jh on 2014-06-20.
 */
public class GamePlayScreen implements Screen {
    //variables
    private MagnetTrip game;
    private GameWorld world;
    private int displayWidth;
    private int displayHeight;
    OrthographicCamera cam;

    public GamePlayScreen(MagnetTrip game, int width, int height) {
        this.game = game;
        this.displayWidth = width;
        this.displayHeight = height;
        Gdx.app.log("MNCGame", "width = " + width);
        Gdx.app.log("MNCGame", "height = " + height);

        cam = new OrthographicCamera(width, height);
        cam.position.set(width/2f, height/2f, 0);
        ScreenViewport viewport = new ScreenViewport(cam);

        world = new GameWorld(viewport);



        //json generate
        FileHandle file = Gdx.files.local("mapDatas.json");
        MapPieceFileWriter mapPieceFileWriter = new MapPieceFileWriter();

        ObstacleData obstacleData1 = new ObstacleData(ObstacleData.PULL_PLANET, new Vector2(100, 150), 3, 70, 70);
        ObstacleData obstacleData2 = new ObstacleData(ObstacleData.PUSH_PLANET, new Vector2(400, 380), 4, 70, 70);
        ObstacleData obstacleData3 = new ObstacleData(ObstacleData.BASIC_WALL, new Vector2(450, 150), 4, 200, 20);
        MapPiece mapPiece = new MapPiece();
        mapPiece.add(obstacleData1);
        mapPiece.add(obstacleData2);
        mapPiece.add(obstacleData3);
        mapPieceFileWriter.add(mapPiece);


        obstacleData1 = new ObstacleData(ObstacleData.PULL_PLANET, new Vector2(100, 390), 3, 70, 70);
        obstacleData2 = new ObstacleData(ObstacleData.PULL_PLANET,new Vector2(400, 150), 5, 70, 70);
        obstacleData3 = new ObstacleData(ObstacleData.PULL_PLANET,new Vector2(600, 300), 5, 70, 70);
        mapPiece = new MapPiece();
        mapPiece.add(obstacleData1);
        mapPiece.add(obstacleData2);
        mapPiece.add(obstacleData3);
        mapPieceFileWriter.add(mapPiece);

        obstacleData1 = new ObstacleData(ObstacleData.PUSH_PLANET, new Vector2(100, 100), 3, 70, 70);
        obstacleData2 = new ObstacleData(ObstacleData.PULL_PLANET, new Vector2(350, 250), 4, 70, 70);
        obstacleData3 = new ObstacleData(ObstacleData.PULL_PLANET, new Vector2(600, 400), 4, 70, 70);
        mapPiece = new MapPiece();
        mapPiece.add(obstacleData1);
        mapPiece.add(obstacleData2);
        mapPiece.add(obstacleData3);
        mapPieceFileWriter.add(mapPiece);


        mapPieceFileWriter.writeFile(file);

        FileHandle readFile = Gdx.files.internal("mapDatas.json");

        MapPiecesFileReader mapPiecesFileReader = new MapPiecesFileReader(readFile);
        Gdx.app.log("GamePlayScreen", "mapPieces Test = " + mapPiecesFileReader.get(0).get(0));
    }

    //Screen implemented methods
    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 1, 1);

        if(world.getState() == GameWorld.GAME_RESTART) {
            game.setScreen(new GamePlayScreen(game, displayWidth, displayHeight));
        }

        world.update();
        world.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        world.dispose();
    }
}
