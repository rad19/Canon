package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class Cannonball {

    // How large each cannonball will be
    private final int CANNONBALL_RADIUS = 16;

    // Gravitational constant on Earth
    private final double G = 9.81;

    // Initial X & Y positions of the cannonball
    private double initX;
    private double initY;

    // Initial X & Y positions of the cannonball
    private double currX;
    private double currY;

    // The angle the cannonball was fired at, in radians
    private double angle;

    // Velocity of the cannonball
    private double xVelocity;
    private double yVelocity;
    private int velocity;

    // Each cannonball will be black
    private Paint cannonballPaint = new Paint(Color.BLACK);

    public Cannonball(int x, int y, double angle, int velocity) {
        this.initX = (double) x;
        this.initY = (double) y;
        this.currX = this.initX;
        this.currY = this.initY;
        this.angle = angle;
        this.xVelocity = Math.cos(angle) * velocity;
        this.yVelocity = Math.sin(angle) * velocity;
        this.velocity = velocity;
    }

    public void drawCannonball(Canvas c) {
        c.drawCircle((float)this.currX, (float)this.currY, 16f, cannonballPaint);
    }

    public void move(double t, int num) {
        this.currX = this.initX + this.xVelocity * t;
        this.currY = this.initY - ((this.yVelocity * t) - (.5 * G * (t * t)));
    }


    public void checkIfOnScreen() {

    }

    public int getCurrX() {
        return (int)this.currX;
    }

    public int getCurrY() {
        return (int)this.currY;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public int getVelocity() {
        return velocity;
    }

}
