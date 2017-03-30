package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class CanonAnimator implements Animator {

    @Override
    public int interval() {
        return 0;
    }

    @Override
    public int backgroundColor() {
        return Color.BLUE;
    }

    @Override
    public void tick(Canvas c) {
        SmallTarget smallTarget1 = new SmallTarget(10, 50, 50);
        smallTarget1.drawTarget(c);
    }

    @Override
    public boolean doPause() {
        return false;
    }

    @Override
    public boolean doQuit() {
        return false;
    }

    @Override
    public void onTouch(MotionEvent event) {

    }

}
