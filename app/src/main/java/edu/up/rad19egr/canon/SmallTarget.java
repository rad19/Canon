// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// 3 March 2017

package edu.up.rad19egr.canon;

import android.graphics.Canvas;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class SmallTarget extends Target {

    public SmallTarget(int pointValue, int x, int y, boolean hit) {
        super(pointValue, x, y, hit);
        setHeight(50);
    }

    public void move(double t) {
        setXCor(getXCor());
        setYCor((int) t * getYCor() % 50);
    }

}
