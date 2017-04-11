// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// Part A: 3 April 2017; Part B: 10 April 2017
// This class is abstract and must be implemented depending on what sort of
// preferences that the user has about position, size, score, etc.

package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by PouyaRad on 3/29/17.
 */

public abstract class Target {

    // Instance variables for the basic information of the target.
    // All targets have the same width of 20.
    private int xCor;
    private int yCor;
    private int height;
    private int width = 20;
    private int pointValue;

    // Buffer for where the cannonball can strike the target and still
    // register as being hit.
    private int hitBuff = 24;

    // Paint for the target, depending on its state.
    private Paint paintBrush = new Paint();

    // Booleans indicating if the target has been hit and scored.
    private boolean isHit;
    private boolean isScored;

    // Constructor for the Target on the screen.
    // Accepts 4 parameters: an integer indicating the point value, two
    // integers for the X & Y position of the target, and a boolean indicating
    // if the target has been hit.
    public Target(int pointValue, int x, int y, boolean hit) {
        this.pointValue = pointValue;
        this.xCor = x;
        this.yCor = y;
        this.isHit = hit;
        setPaintColor();
    }

    // Getter for if the target has been hit by a cannonball.
    // Returns a boolean indicating if the target has been hit (true).
    public boolean getIsHit() {
        return isHit;
    }

    // Setter for the target to set the target as being hit or not.
    // Accepts one parameter: a boolean indicating if the target has been hit.
    public void setIsHit(boolean hit) {
        if(hit) {
            isHit = true;
            paintBrush.setColor(Color.RED);
        }
    }

    // Getter for the point value of the target. Returns an integer that is
    // the target's point value.
    public int getPointWorth() {
        return this.pointValue;
    }

    // Sets the paint color of the target depending on its current state,
    // specifically with regard to if it has been hit or not.
    private void setPaintColor() {
        if(isHit) {
            paintBrush.setColor(Color.RED);
        } else {
            paintBrush.setColor(Color.GREEN);
        }
    }

    // Setter for the height of the target, depending on the implementor's
    // preference.
    // Accepts one parameter: an integer indicating the height that the target
    // should be set to.
    public void setHeight(int h) {
        this.height = h;
    }

    // This method draws the target on the canvas.
    // It accepts one parameter: the Canvas that the target is to be drawn on.
    // The Target is an oval that is rather narrow to aid with perspective.
    // Since it was made for a 2D game, the target could have been a rectangle
    // to represent how the visual was from a side view, but the use of a
    // narrow oval appears to be more aesthetic in representing a target, which
    // is most often a circle.
    public void drawTarget(Canvas canvas) {
        canvas.drawOval((float)this.xCor, (float)this.yCor, (float)this.xCor+this.width, (float)this.yCor+this.height, paintBrush);
    }

    // This method checks to see if the target contains a certain point.
    // It accepts two parameters: an integer for X and Y coordinates that
    // represent the point being checked.
    // It returns a boolean representing if the point is contained in the
    // target, plus its buffer.
    public boolean containsPoint(int x, int y) {
        Rect r = new Rect(this.xCor-hitBuff, this.yCor-hitBuff, this.xCor+this.width+hitBuff, this.yCor+height+hitBuff);
        return r.contains(x, y);
    }

    // Setter method to score a target, indicating that it has been scored
    // and should not be scored again even if it is struck.
    public void score() {
        this.isScored = true;
    }

    // This method is a getter to indicate that the target has been scored
    // and the points have been added to the player's total score.
    // Returns a boolean true if it has been scored and false if not.
    public boolean isScored() {
        return this.isScored;
    }

    // Getter for the X-Coordinate of the target.
    // Returns an integer that is the X-Coordinate of the target.
    public int getXCor() {
        return this.xCor;
    }

    // Getter for the Y-Coordinate of the target.
    // Returns an integer that is the Y-Coordinate of the target.
    public int getYCor() {
        return this.yCor;
    }

}
