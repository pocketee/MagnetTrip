package com.harry.MagnetTrip.Json;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 * Created by jh on 2014-07-11.
 */
public abstract class JsonFileWriter<DataType> {
    protected Json json;
    protected ArrayList<DataType> dataList;

    public JsonFileWriter() {
        json = new Json();
        dataList = new ArrayList<DataType>();
    }

    public void writeFile(FileHandle file) {
        String txt = json.prettyPrint(dataList);
        file.writeString(txt, false);

        Gdx.app.log("JsonFileWriter", txt);
    }

    public void add(DataType dataType) {
        dataList.add(dataType);
    }
}
