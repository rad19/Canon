package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class Cannon {

    private int canonBallCount;
    private int angle;
    private Paint paintBrush = new Paint();

    public Cannon() {
        this.canonBallCount = 10;
        this.angle = 0;
    }

    public void drawCanon(Canvas canvas) {
        paintBrush.setColor(Color.GRAY);
        ArrayList<Float> xCoordinates = new ArrayList<>();
        xCoordinates.add(50f);
        xCoordinates.add(0f);
        ArrayList<Float> yCoordinates = new ArrayList<>();
        drawBase(canvas);
    }

    private void drawBase(Canvas canvas) {
        paintBrush.setColor(Color.BLACK);
        canvas.drawCircle(100f, 1100f, 40f, paintBrush);
    }





}
