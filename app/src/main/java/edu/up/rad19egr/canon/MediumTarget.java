package edu.up.rad19egr.canon;

import android.graphics.Canvas;

/**
 * Created by PouyaRad on 4/4/17.
 */

public class MediumTarget extends Target {

    public MediumTarget(int pointValue, int x, int y, boolean hit) {
        super(pointValue, x, y, hit);
        setHeight(100);
    }

    public void move(double t) {

    }

}
