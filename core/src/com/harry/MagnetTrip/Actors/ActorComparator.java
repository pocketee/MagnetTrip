package com.harry.MagnetTrip.Actors;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Comparator;

/**
 * Created by jh on 2014-07-13.
 */
public class ActorComparator implements Comparator<Actor> {
    @Override
    public int compare(Actor actor1, Actor actor2) {
        if (actor1.getZIndex() < actor2.getZIndex()) {
            return -1;
        } else if (actor1.getZIndex() == actor2.getZIndex()) {
            return 0;
        } else {
            return 1;
        }
    }
}
