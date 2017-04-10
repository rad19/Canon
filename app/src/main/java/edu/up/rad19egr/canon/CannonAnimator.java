// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// 3 March 2017

package edu.up.rad19egr.canon;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by PouyaRad on 3/29/17.
 */

public class CannonAnimator implements Animator {

    // Draws a nice floor for the animation.
    public AnimationBase base = new AnimationBase(0, 1140, 1600, 1400);

    // Small, medium, and large targets to be aimed at, respectively.
    public SmallTarget target1 = new SmallTarget(50, 1000, 200, false);
    public MediumTarget target2 = new MediumTarget(25, 1400, 100, false);
    public LargeTarget target3 = new LargeTarget(5, 1300, 400, false);

    // An ArrayList of Targets to store all of the targets to be used in the
    // animation.
    public ArrayList<Target> targetList = new ArrayList<Target>
                             (Arrays.asList(target1, target2, target3));

    // The Cannon for the animation.
    public Cannon mainCannon = new Cannon();

    // The Cannonball that is currently in the animation.
    public Cannonball ball;

    public ArrayList<Cannonball> cannonballs = new ArrayList<>();

    // A boolean indicating if the Cannon has been fired.
    private boolean isFired = false;

    // A boolean indicating if the current Cannonball, should it exist, is on
    // the animation's portion of the screen.
    private boolean isBallOnScreen = false;

    // An integer, keeping track of the ticks for the animation.
    private int count = 0;

    // A double that stores the time at which the most recent call for firing
    // a cannonball was made.
    private double fireTime;

    // A double that keeps track of the time elapsed since the ball has been
    // on the animation's canvas.
    private double time;

    // Integers that store the height and width of the canvas being used.
    private int canvasHeight;
    private int canvasWidth;

    // Interval between animation frames: .03 seconds
    // Returns an integer of the time interval between frames in milliseconds.
    @Override
    public int interval() {
        return 30;
    }

    // Sets the background color of the animation's canvas.
    // A nice light blue, representing the day sky.
    // Returns an integer for the color that we want.
    @Override
    public int backgroundColor() {
        return Color.rgb(180, 200, 255);
    }

    // This method performs one clock tick, specified by the interval method
    // to draw the next animation frame. Used to reflect the passage of time
    // for relevant animations (the motion of the cannonball).
    // Accepts 1 parameter: the Canvas that the animation frame is drawn on.
    @Override
    public void tick(Canvas c) {

        // Set the height and width of the animation canvas.
        canvasHeight = c.getHeight();
        canvasWidth = c.getWidth();

        // Increment the time that has elapsed since the start of the app's
        // animation frame.
        count++;

        // Calculate a usable time "t" for the physics equations in the
        // Cannonball class's "move" method.
        double t = (10 * (time - fireTime) / 1000);

        for(Target target : targetList) {
            if(!target.getIsHit()) {
                target.move(t);
            }
            target.drawTarget(c);
        }

        // Check to see if a cannonball has been fired and then begin drawing
        // its motion.
        if(isBallOnScreen) {
            time = time + 1;
            ball.move(t * 10, mainCannon.getGravity());
            ball.drawCannonball(c);
            /*
            for(Cannonball cb : cannonballs) {
                cb.move(t * 10);
                cb.drawCannonball(c);
            }
            */

        }

        // Draw the base of the animation, the cannon (depending on its angle),
        // and all of the targets to be used.
        base.drawBase(c);
        mainCannon.drawCanon(c);

        // Check to see if there is a Cannonball created.
        if(ball != null) {

            // Then check if it is on the screen (i.e. boolean is set true) and
            // if it is still visible on the canvas.
            if(isBallOnScreen && this.checkIfOffScreen()) {

                // If it is no longer within the bounds of the canvas, set the
                // relevant boolean values to false and get rid of the ball so
                // a new one can be created later. Also, reset the times for
                // the ball's movement.
                isBallOnScreen = false;
                isFired = false;
                ball = null;
                fireTime = 0;
                time = 0;
            }
        }

        for(int i = 0; i < targetList.size(); i++) {
            Target currTarget = targetList.get(i);
            if(isBallOnScreen && currTarget.containsPoint((int)ball.getCurrX(), (int)ball.getCurrY())) {
                currTarget.setIsHit(true);
                currTarget.drawTarget(c);
            }
        }

    }

    // Tells whether the animation should be paused.
    // We never pause the animation so. So it will always return false.
    // Returns a boolean if the animation should be paused.
    @Override
    public boolean doPause() {
        return false;
    }

    // Tells whether the animation should be stopped.
    // We never stop the animation so. So it will always return false.
    // Returns a boolean if the animation should be stopped.
    @Override
    public boolean doQuit() {
        return false;
    }

    // This method is called whenever the user touches the AnimationCanvas
    // so that it can respond to the event.
    @Override
    public void onTouch(MotionEvent event) {

    }

    // This method increases the animation's Cannon angle when it is called.
    public void increaseCannonAngle() {
        mainCannon.increaseAngle();
    }

    // This method decreases the animation's Cannon angle when it is called.
    public void decreaseCannonAngle() {
        mainCannon.decreaseAngle();
    }

    // This method gets the Cannon's current angle in degrees.
    // Returns an integer of the animation's Cannon angle.
    public int getCannonAngle() {
        return mainCannon.getDegAngle();
    }

    // This method fires the animation's Cannon when called.
    public void fireCannon() {

        // Initialize the relevant times for the Cannon to be used with drawing
        // the cannonball.
        fireTime = count;
        time = fireTime;

        ball = mainCannon.fire();
        // cannonballs.add(ball);

        // Set appropriate booleans as true.
        this.isBallOnScreen = true;
        isFired = true;
    }

    // This method checks to see if the current Cannonball is off of the screen
    // (i.e. it is no longer visible on the AnimationCanvas).
    // It returns a boolean true (the ball is off the screen) or false (ball is
    // off of the screen).
    public boolean checkIfOffScreen() {
        if(ball.getCurrX() > canvasWidth && (ball.getCurrY() > canvasHeight || ball.getCurrY() < 0)) {
            return true;
        } else {
            return false;
        }
    }



}
