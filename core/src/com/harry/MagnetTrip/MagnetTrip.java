package com.harry.MagnetTrip;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.harry.MagnetTrip.Screens.GamePlayScreen;

public class MagnetTrip extends Game implements ApplicationListener {
    private int DISPLAY_WIDTH = 800;
    private int DISPLAY_HEIGHT = 480;
    @Override
    public void create() {
        Assets.load();
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            setScreen(new GamePlayScreen(this, DISPLAY_WIDTH, DISPLAY_HEIGHT));
            Gdx.app.log("MyGame", "android");
        } else if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
            setScreen(new GamePlayScreen(this, DISPLAY_WIDTH, DISPLAY_HEIGHT));
            //setScreen(new GamePlayScreen(this, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
            Gdx.app.log("MyGame", "desktop");
        }
    }
}
