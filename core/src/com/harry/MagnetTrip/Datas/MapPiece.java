package com.harry.MagnetTrip.Datas;

import java.util.ArrayList;

/**
 * Created by jh on 2014-07-10.
 */
public class MapPiece {
    ArrayList<ObstacleData> obstacleList;

    public MapPiece() {
        obstacleList = new ArrayList<ObstacleData>();
    }

    public void add(ObstacleData obstacleData) {
        obstacleList.add(obstacleData);
    }

    public void remove(ObstacleData obstacleData) {
        obstacleList.remove(obstacleData);
    }

    public ObstacleData get(int index) {
        return obstacleList.get(index);
    }

    public int size() {
        return obstacleList.size();
    }
}
