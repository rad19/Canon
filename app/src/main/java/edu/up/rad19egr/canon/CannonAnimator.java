package edu.up.rad19egr.canon;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class CannonAnimator implements Animator {

    public SmallTarget target1 = new SmallTarget(5, 1000, 200);
    public LargeTarget target2 = new LargeTarget(15, 1300, 400);
    public Cannon mainCanon = new Cannon();
    public AnimationBase base = new AnimationBase(0, 1140, 1600, 1400);
    public int count = 0;


    @Override
    public int interval() {
        return 30;
    }

    @Override
    public int backgroundColor() {
        return Color.WHITE;
    }

    @Override
    public void tick(Canvas c) {
        target1.drawTarget(c);
        target2.drawTarget(c);
        mainCanon.drawCanon(c);
        base.drawBase(c);

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
