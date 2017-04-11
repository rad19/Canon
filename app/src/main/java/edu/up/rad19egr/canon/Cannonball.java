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

import java.util.Random;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class Cannonball {

    // Initial X & Y positions of the cannonball
    private double initX;
    private double initY;

    // Current X & Y positions of the cannonball
    private double currX;
    private double currY;

    // The angle the cannonball was fired at, in radians
    private double angle;

    // Velocity of the cannonball
    private int velocity;
    private double xVelocity;
    private double yVelocity;

    // Each cannonball will be black
    private Paint cannonballPaint = new Paint(Color.BLACK);

    // Boolean to indicate if the cannonball has hit the ground after being
    // fired, initially set to false because it will be above the ground when
    // fired.
    public boolean isOnGround = false;

    // Constructor for Cannonball.
    // Accepts 4 parameters: integers X & Y, for the starting position of the
    // cannonball (always will be Cannon's origin); a double for the angle
    // that the ball will be fired at; and an integer for the velocity of the
    // cannonball.
    public Cannonball(int x, int y, double angle, int velocity) {
        this.initX = (double) x;
        this.initY = (double) y;
        this.currX = this.initX;
        this.currY = this.initY;
        this.angle = angle;
        this.velocity = velocity;
        this.xVelocity = Math.cos(angle) * velocity;
        this.yVelocity = Math.sin(angle) * velocity;
    }

    // Draws the cannonball on the canvas.
    // Accepts one parameter: the Canvas that is being drawn on.
    public void drawCannonball(Canvas c) {
        c.drawCircle((float)this.currX, (float)this.currY, 16f, cannonballPaint);
    }

    // Moves the cannonball's current X & Y positions, depending on the angle
    // at which it was fired at.
    // Accepts 1 parameter: a double, representing the variable for time to
    // be used in equations of projectile motion.
    // NOTE: these equations and the motion of the ball do not accurately
    // reflect motion in real life, unfortunately. Yet here I am, using
    // physics in my CS class. I never thought the day would come.
    public void move(double t, int g) {
        this.currX = this.initX + (this.xVelocity * t);
        // Check to see if the ball has hit the ground
        if(isOnGround) {
            // the hard coded top of the floor minus radius of ball
            this.currY = 1140 - 16;
        } else {
            this.currY = this.initY - (this.yVelocity * t) + (.5 * g * (t * t));
        }
    }

    // This method gets the current X position of the cannonball.
    // It returns a double of the X-Coordinate.
    public double getCurrX() {
        return this.currX;
    }

    // This method gets the current Y position of the cannonball.
    // It returns a double of the Y-Coordinate.
    public double getCurrY() {
        return this.currY;
    }

    // This method gets the velocity at which the cannonball was shot at.
    // It returns an integer that is the velocity.
    public int getVelocity() {
        return velocity;
    }

}
