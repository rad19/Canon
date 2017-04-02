package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by PouyaRad on 3/29/17.
 */

public abstract class Target {

    private int pointValue;

    protected Paint paintBrush = new Paint();

    protected boolean isHit = false;

    protected int xCor;

    protected int yCor;

    public Target(int pointValue, int x, int y) {
        this.pointValue = pointValue;
        this.xCor = x;
        this.yCor = y;
        setPaintColor();
    }

    public boolean getIsHit() {
        return isHit;
    }

    public void setIsHit(boolean hit) {
        if(hit) {
            isHit = true;
            paintBrush.setColor(Color.RED);
        }
    }

    public int getPointWorth() {
        return pointValue;
    }

    public void setPaintColor() {
        if(isHit) {
            paintBrush.setColor(Color.RED);
        } else {
            paintBrush.setColor(Color.GREEN);
        }
    }

    public abstract void drawTarget(Canvas canvas);


}
