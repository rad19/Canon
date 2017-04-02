package edu.up.rad19egr.canon;

import android.annotation.TargetApi;
import android.app.Activity;
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
    public Cannon mainCannon = new Cannon();
    public AnimationBase base = new AnimationBase(0, 1140, 1600, 1400);
    private int count = 0;

    @Override
    public int interval() {
        return 30;
    }

    @Override
    public int backgroundColor() {
        return Color.rgb(180, 200, 255);
    }

    @Override
    public void tick(Canvas c) {
        base.drawBase(c);
        target1.drawTarget(c);
        target2.drawTarget(c);
        mainCannon.drawCanon(c);
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
    @TargetApi(23)
    public void onTouch(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_BUTTON_PRESS) {
            if(event.getActionButton() == R.id.increaseAngleButton) {
                mainCannon.increaseAngle();
            } else if(event.getActionButton() == R.id.decreaseAngleButton) {
                mainCannon.decreaseAngle();
            } else if(event.getActionButton() == R.id.fireCannonBallButton) {
                mainCannon.fire();
            }

        }
    }
}
