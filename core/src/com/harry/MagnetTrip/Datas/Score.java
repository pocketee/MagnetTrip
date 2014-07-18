package com.harry.MagnetTrip.Datas;

/**
 * Created by jh on 2014-07-14.
 */
public class Score {
    private int score;

    public Score() {
        score = 0;
    }

    public void addBaseScore() {
        score += 1;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return ""+score;
    }
}
