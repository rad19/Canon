package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class Cannonball {

    // How large each cannonball will be
    private final float CANNONBALL_RADIUS = 16;

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
    private double velocity;

    // Each cannonball will be black
    private Paint cannonballPaint = new Paint(Color.BLACK);

    public Cannonball(int initX, int initY, double angle, double velocity) {
        this.initX = (double) initX;
        this.initY = (double) initY;
        this.currX = (double) initX;
        this.currY = (double) initY;
        this.angle = angle;
        this.velocity = velocity;
    }

    public void drawCannonball(Canvas c) {
        c.drawCircle((float)currX, (float)currY, CANNONBALL_RADIUS, cannonballPaint);
    }

    public void move() {

    }


}
