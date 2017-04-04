// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// 3 March 2017

package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class Cannon {

    // Starting amount of cannonballs, user has this many chances to hit
    // the targets.
    private int cannonBallCount = 10;

    // Angle that the cannon is at, in radians and degrees (respectively)
    private double radAngle;
    private int degAngle;

    // Arbitrarily set width and length of cannon's barrel, so that it
    // looks aesthetically pleasing.
    private int cannonWidth = 38;
    private int cannonLength = 120;

    // Paint for the cannon
    private Paint paintBrush = new Paint();

    // The position of the cannon on the screen, arbitrarily chosen.
    // Set using a Point object.
    private Point position = new Point(100, 1100);

    // Constructor for Cannon.
    // Requires no parameters, as position and cannonball count are hard coded.
    // Starting angle is arbitrarily set to 45 degrees.
    public Cannon() {
        this.degAngle = 45;
        this.radAngle = (double) degAngle * Math.PI / 180.0;
    }

    // Draws the cannon on the canvas.
    // Accepts one parameter: the Canvas that is being drawn on.
    public void drawCanon(Canvas canvas) {

        // Calculates the X- and Y-Coordinate of each corner of the cannon
        // depending on the angle at which it is currently at. Then draws
        // the cannon.
        paintBrush.setColor(Color.GRAY);

        ArrayList<Float> xCoordinates = new ArrayList<>();

        xCoordinates.add((float)this.position.x);
        xCoordinates.add((float)(this.position.x - (Math.sin(this.radAngle) *
                         this.cannonWidth)));
        xCoordinates.add((float)(this.position.x + (Math.cos(this.radAngle) *
                         this.cannonLength) - (Math.sin(this.radAngle) *
                         this.cannonWidth)));
        xCoordinates.add((float)(this.position.x + (Math.cos(this.radAngle) *
                         this.cannonLength)));

        ArrayList<Float> yCoordinates = new ArrayList<>();

        yCoordinates.add((float)this.position.y);
        yCoordinates.add((float)(this.position.y - (Math.cos(this.radAngle) *
                         this.cannonWidth)));
        yCoordinates.add((float)(this.position.y - (Math.cos(this.radAngle) *
                         this.cannonWidth) - (Math.sin(this.radAngle) *
                         this.cannonLength)));
        yCoordinates.add((float)(this.position.y - (Math.sin(this.radAngle) *
                         this.cannonLength)));

        Path cannonPath = new Path();
        cannonPath.reset();
        cannonPath.moveTo(xCoordinates.get(0), yCoordinates.get(0));
        for(int i = 1; i < xCoordinates.size(); i++) {
            cannonPath.lineTo(xCoordinates.get(i), yCoordinates.get(i));
        }
        cannonPath.close();
        canvas.drawPath(cannonPath, paintBrush);

        drawWheel(canvas);
    }

    // Helper method to draw a wheel for the canvas, so that it looks more
    // realistic.
    // Accepts one parameter: the Canvas that the animation is drawn on.
    private void drawWheel(Canvas canvas) {
        paintBrush.setColor(Color.BLACK);
        canvas.drawCircle((float)this.position.x, (float)this.position.y, 40f, paintBrush);
    }

    // This method increases the cannon's angle when called and sets both the
    // angle in degrees and radians after it is updated.
    public void increaseAngle() {
        this.degAngle++;
        setAngle(degAngle);
    }

    // This method decreases the cannon's angle when called and sets both the
    // angle in degrees and radians after it is updated.
    public void decreaseAngle() {
        this.degAngle--;
        setAngle(this.degAngle);
    }

    // This method gets the current angle of the cannon in degrees.
    // Returns an integer that is the cannon's angle.
    public int getDegAngle() {
        return this.degAngle;
    }

    // This method gets the current angle of the cannon in radians.
    // Returns a double that is the cannon's angle.
    public double getRadAngle() {
        return this.radAngle;
    }

    // This method gets the current angle of the cannon in both radians and
    // degrees.
    // It accepts one parameter: an integer that is the cannon's new angle.
    public void setAngle(int newAngle) {
        this.degAngle = newAngle;
        this.radAngle = this.degAngle * Math.PI / 180.0;
    }

    // This method fires a cannonball, and decrements the number of cannonballs
    // remaining.
    // It returns a new Cannonball object that starts at the center of the
    // cannon with the angle that it was fired at and an arbitrarily chosen
    // initial velocity of 500.
    public Cannonball fire() {
        this.cannonBallCount--;
        return new Cannonball((int)(this.getPosition().x - 19 +
                              Math.cos(this.getRadAngle()) * 4),
                              (int)(this.getPosition().y - 19 +
                              Math.sin(this.getRadAngle()) * 12),
                              this.getRadAngle(), 500);
    }

    // This method gets the current number of cannonballs that the user has.
    // It returns an integer representing the number of cannonballs.
    public int getCannonBallCount() {
        return this.cannonBallCount;
    }

    // This method gets the position of the Cannon.
    // It returns a Point object that stores the X- and Y- coordinate of the
    // cannon.
    public Point getPosition() {
        return this.position;
    }

}
