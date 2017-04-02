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

    private int cannonBallCount;
    private double radAngle;
    private int degAngle;
    private Paint paintBrush = new Paint();
    private Point position = new Point(100, 1100);

    public Cannon() {
        this.degAngle = 25;
        this.radAngle = (double) degAngle * Math.PI / 180.0;
        this.cannonBallCount = 10;
    }

    public void drawCanon(Canvas canvas) {
        int cannonWidth = 38;
        int cannonLength = 120;

        paintBrush.setColor(Color.GRAY);
        ArrayList<Float> xCoordinates = new ArrayList<>();
        xCoordinates.add((float)this.position.x);
        xCoordinates.add((float)(this.position.x - (Math.sin(radAngle) * cannonWidth)));
        xCoordinates.add((float)(this.position.x + (Math.cos(radAngle) * cannonLength) - (Math.sin(radAngle) * cannonWidth)));
        xCoordinates.add((float)(this.position.x + (Math.cos(radAngle) * cannonLength)));
        ArrayList<Float> yCoordinates = new ArrayList<>();
        yCoordinates.add((float)this.position.y);
        yCoordinates.add((float)(this.position.y - (Math.cos(radAngle) * cannonWidth)));
        yCoordinates.add((float)(this.position.y - (Math.cos(radAngle) * cannonWidth) - (Math.sin(radAngle) * cannonLength)));
        yCoordinates.add((float)(this.position.y - (Math.sin(radAngle) * cannonLength)));
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

    private void drawWheel(Canvas canvas) {
        paintBrush.setColor(Color.BLACK);
        canvas.drawCircle((float)this.position.x, (float)this.position.y, 40f, paintBrush);
    }

    public void increaseAngle() {
        this.degAngle++;
        setAngle(degAngle);
    }

    public void decreaseAngle() {
        this.degAngle--;
        setAngle(degAngle);
    }

    public double getCurrentAngle() {
        return this.degAngle;
    }

    public void setAngle(int newAngle) {
        this.degAngle = newAngle;
        this.radAngle = this.degAngle * Math.PI / 180.0;
    }

    public Cannonball fire() {
        this.cannonBallCount--;
        if(cannonBallCount >= 0) {
            Cannonball cb = new Cannonball(position.x, position.y, radAngle, 10);
            return cb;
        }
        return null;
    }

    public int getCannonBallCount() {
        return this.cannonBallCount;
    }

}
