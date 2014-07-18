package com.harry.MagnetTrip.Json;


import com.badlogic.gdx.files.FileHandle;
import com.harry.MagnetTrip.Datas.MapPiece;

/**
 * Created by jh on 2014-07-11.
 */
public class MapPiecesFileReader extends JsonFileReader<MapPiece> {
    public MapPiecesFileReader(FileHandle file) {
        super(file);
    }
}
