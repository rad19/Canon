// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// Part A: 3 April 2017; Part B: 10 April 2017

package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by PouyaRad on 4/1/17.
 */

// This class draws a simple "ground" on which the cannon rests

public class AnimationBase {

    // Instance variable that store the dimensions & location of the ground.
    private float left;
    private float top;
    private float right;
    private float bottom;

    // Constructor for the ground on the animation.
    // Accepts 4 parameters: the left X-coordinate, the top Y-coordinate
    // the right X-coordinate, and the bottom Y-coordinate.
    public AnimationBase(int left, int top, int right, int bottom) {
        this.left = (float) left;
        this.top = (float) top;
        this.right = (float) right;
        this.bottom = (float) bottom;
    }

    // Simple method to draw the ground on the animation screen.
    // Accepts one parameter: the Canvas that the animation should be drawn on.
    public void drawBase(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        c.drawRect(left, top, right, bottom, paint);
    }

}
