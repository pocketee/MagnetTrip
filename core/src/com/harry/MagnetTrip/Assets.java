package com.harry.MagnetTrip;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by jh on 2014-06-27.
 */
public class Assets {
    //Sheets
    public static Texture forwardCarSheet;
    public static Texture backwardCarSheet;
    public static Texture planetSheet;
    public static Texture planetFieldInactiveSheet;
    public static Texture pullPlanetFieldActiveSheet;
    public static Texture psuhPlanetFieldActiveSheet;
    public static Texture basicWallSheet;
    public static Texture mapSheet;


    //Animations;
    public static Animation forwardCarAnimation;
    public static Animation backwardCarAnimation;
    public static Animation planetAnimation;
    public static Animation planetFieldInactiveAnimation;
    public static Animation pullPlanetFieldActiveAnimation;
    public static Animation pushPlanetFieldActiveAnimation;
    public static Animation basicWallAnimation;
    public static Animation mapAnimation;

    public static void load() {
        forwardCarSheet = new Texture("testcar.png");
        backwardCarSheet = new Texture("testcar_inverse.png");
        planetSheet = new Texture(Gdx.files.internal("basic_planet.gif"));
        planetFieldInactiveSheet = new Texture(Gdx.files.internal("planet_field_inactive.png"));
        pullPlanetFieldActiveSheet = new Texture(Gdx.files.internal("pull_planet_field_active.png"));
        psuhPlanetFieldActiveSheet = new Texture(Gdx.files.internal("push_planet_field_active.png"));
        basicWallSheet = new Texture(Gdx.files.internal("basic_wall.png"));
        mapSheet = new Texture(Gdx.files.internal("space_background_short.jpg"));
                                                                                //width, height dpi
        forwardCarAnimation = loadAnimation(forwardCarSheet, 0.025f, 1, 1);     //168, 100      30dpi
        backwardCarAnimation = loadAnimation(forwardCarSheet, 0.025f, 1, 1);    //168, 100      30dpi
        planetAnimation = loadAnimation(planetSheet, 0.025f, 1, 1);         //102, 102      30dpi
        planetFieldInactiveAnimation = loadAnimation(planetFieldInactiveSheet, 0.025f, 1, 1); //560, 560 100.80dpi
        pullPlanetFieldActiveAnimation = loadAnimation(pullPlanetFieldActiveSheet, 0.025f, 1, 1);
        pushPlanetFieldActiveAnimation = loadAnimation(psuhPlanetFieldActiveSheet, 0.025f, 1, 1);
        basicWallAnimation = loadAnimation(basicWallSheet, 0.025f, 1, 1);
        mapAnimation = loadAnimation(mapSheet, 0.025f, 1, 1);
    }

    private static Animation loadAnimation(Texture sheet, float frameDuration, int frame_cols, int frame_rows) {
        TextureRegion[] Frames;

        TextureRegion[][] tmp = TextureRegion.split(sheet, sheet.getWidth()/frame_cols, sheet.getHeight()/frame_rows);
        Gdx.app.log("Assets", "Sheet.getWidth() = " + sheet.getWidth());
        Frames = new TextureRegion[frame_cols * frame_rows];
        int index = 0;
        for (int i = 0; i < frame_rows; i++) {
            for (int j = 0; j < frame_cols; j++) {
                Frames[index++] = tmp[i][j];
            }
        }

        return new Animation(frameDuration, Frames);
    }
}
