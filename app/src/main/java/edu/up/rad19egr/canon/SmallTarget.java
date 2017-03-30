package edu.up.rad19egr.canon;

import android.graphics.Canvas;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class SmallTarget extends Target {

    public SmallTarget(int pointValue, int x, int y) {
        super(pointValue, x, y);
    }

    @Override
    public void drawTarget(Canvas canvas) {
        canvas.drawRect((float)xCor, (float)yCor, (float)xCor+15, (float)yCor+50, paintBrush);
    }

}
