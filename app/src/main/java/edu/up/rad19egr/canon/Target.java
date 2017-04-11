// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// 3 March 2017

package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by PouyaRad on 3/29/17.
 */

public abstract class Target {

    private int xCor;
    private int yCor;
    private int initXCor;
    private int initYCor;
    private int height;
    private int width = 20;

    private int hitBuff = 24;
    private int pointValue;

    private Paint paintBrush = new Paint();

    private boolean isHit;
    private boolean isScored;

    public Target(int pointValue, int x, int y, boolean hit) {
        this.pointValue = pointValue;
        this.xCor = x;
        this.initXCor = x;
        this.yCor = y;
        this.initYCor = y;
        this.isHit = hit;
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
        return this.pointValue;
    }

    private void setPaintColor() {
        if(isHit) {
            paintBrush.setColor(Color.RED);
        } else {
            paintBrush.setColor(Color.GREEN);
        }
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void drawTarget(Canvas canvas) {
        canvas.drawOval((float)this.xCor, (float)this.yCor, (float)this.xCor+this.width, (float)this.yCor+this.height, paintBrush);
    }

    public boolean containsPoint(int x, int y) {
        Rect r = new Rect(this.xCor-hitBuff, this.yCor-hitBuff, this.xCor+this.width+hitBuff, this.yCor+height+hitBuff);
        return r.contains(x, y);
    }

    public void score() {
        this.isScored = true;
    }

    public boolean isScored() {
        return this.isScored;
    }

    public int getXCor() {
        return this.xCor;
    }

    public int getYCor() {
        return this.yCor;
    }

    public void setXCor(int x) {
        this.xCor = x;
    }

    public void setYCor(int y) {
        this.yCor = y;
    }

    public int getInitXCor() {
        return this.xCor;
    }

    public int getInitYCor() {
        return this.yCor;
    }

}
