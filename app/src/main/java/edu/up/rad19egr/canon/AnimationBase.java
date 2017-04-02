package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by PouyaRad on 4/1/17.
 */

// This class draws a simple "ground" on which the cannon rests
public class AnimationBase {

    private float left;
    private float top;
    private float right;
    private float bottom;

    public AnimationBase(int left, int top, int right, int bottom) {
        this.left = (float) left;
        this.top = (float) top;
        this.right = (float) right;
        this.bottom = (float) bottom;
    }

    public void drawBase(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        c.drawRect(left, top, right, bottom, paint);
    }

}
