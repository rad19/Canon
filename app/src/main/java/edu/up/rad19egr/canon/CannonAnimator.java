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
    public Cannonball ball = new Cannonball(mainCannon.getPosition().x, mainCannon.getPosition().y, mainCannon.getRadAngle(), 10);
    public AnimationBase base = new AnimationBase(0, 1140, 1600, 1400);
    public boolean isFired = false;
    private int count = 0;
    private Paint p = new Paint(Color.WHITE);

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
        count++;
        double time = (double) count / 1000;
        int num = count * 15;
        base.drawBase(c);
        target1.drawTarget(c);
        target2.drawTarget(c);
        mainCannon.drawCanon(c);
        if(isFired) {
            ball.move(time, num);
            ball.drawCannonball(c);

        }
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

    public void increaseCannonAngle() {
        mainCannon.increaseAngle();
    }

    public void decreaseCannonAngle() {
        mainCannon.decreaseAngle();
    }

    public int getCannonAngle() {
        return mainCannon.getDegAngle();
    }

    public void fireCannon() {
        ball = mainCannon.fire();
        this.isFired = true;
    }

}
