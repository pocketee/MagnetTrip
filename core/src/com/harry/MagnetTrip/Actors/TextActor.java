package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by jh on 2014-07-13.
 */

public class TextActor extends Actor {
    BitmapFont font;
    int fontSize;
    String content;

    public TextActor(FileHandle ttfFile, int fontSize, Color color, Vector2 pos) {
        this.content = new String("");
        this.fontSize = fontSize;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(ttfFile);
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;
        this.font = generator.generateFont(parameter);
        this.font.setColor(color);
        generator.dispose();

        setText("");
        setX(pos.x);
        setY(pos.y);
    }

    public void setText(String text) {
        content = text;
        //Gdx.app.log("TextActor", "width = " + font.getBounds(content).width);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        font.draw(batch, content, getX(), getY());
    }
}
