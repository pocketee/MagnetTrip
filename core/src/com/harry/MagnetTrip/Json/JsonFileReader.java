package com.harry.MagnetTrip.Json;

import java.util.ArrayList;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

/**
 * Created by jh on 2014-07-11.
 */
public abstract class JsonFileReader<DataType> {
    protected Json json;
    protected ArrayList<DataType> dataList;
    protected FileHandle file;
    protected String fileContent;

    public JsonFileReader(FileHandle file) {
        this.json = new Json();
        this.dataList = new ArrayList<DataType>();
        this.fileContent = file.readString();
        this.dataList = json.fromJson(ArrayList.class, this.fileContent);
        this.file = file;
    }

    public DataType get(int index) {
        return dataList.get(index);
    }
    public int size() {
        return dataList.size();
    }
}
