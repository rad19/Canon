// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// Part A: 3 April 2017; Part B: 10 April 2017

package edu.up.rad19egr.canon;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CannonMainActivity extends AppCompatActivity {

    private AnimationCanvas myCanvas;
    private CannonAnimator cannonAnimator;

    private Button increaseAngleButton;
    private Button decreaseAngleButton;
    private Button fireButton;

    private TextView currentAngleTV;
    private TextView notificationTV;
    private TextView scoreboardTV;
    private TextView gravityTV;

    private SeekBar gravitySeekBar;

    private MediaPlayer mp;

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        cannonAnimator = new CannonAnimator();
        myCanvas = new AnimationCanvas(this, cannonAnimator);
        LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.activity_cannon_main);
        mainLayout.addView(myCanvas);

        increaseAngleButton = (Button)findViewById(R.id.increaseAngleButton);
        decreaseAngleButton = (Button)findViewById(R.id.decreaseAngleButton);
        fireButton = (Button)findViewById(R.id.fireCannonBallButton);
        increaseAngleButton.setOnTouchListener(new increaseAngleButtonListener());
        decreaseAngleButton.setOnTouchListener(new decreaseAngleButtonListener());
        fireButton.setOnClickListener(new fireButtonListener());

        currentAngleTV = (TextView)findViewById(R.id.cannonAngleTextView);
        notificationTV = (TextView)findViewById(R.id.notificationTextView);
        scoreboardTV = (TextView)findViewById(R.id.scoreboardTextView);
        gravityTV = (TextView)findViewById(R.id.gravityTV);
        score = 0;
        currentAngleTV.setText("Current Angle: 45 Degrees");
        notificationTV.setText("" + cannonAnimator.mainCannon.getCannonBallCount() + " cannonballs left.");
        scoreboardTV.setText("Score: " + this.score + " points.");
        gravityTV.setText("Gravity: 100");

        gravitySeekBar = (SeekBar)findViewById(R.id.gravitySeekBar);
        gravitySeekBar.setOnSeekBarChangeListener(new gravitySeekBarListener());
        gravitySeekBar.setProgress(100);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.blast);

        myCanvas.invalidate();

        mainLayout.invalidate();

    }

    private class increaseAngleButtonListener implements Button.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(cannonAnimator.mainCannon.getDegAngle() < 90) {
                cannonAnimator.increaseCannonAngle();
                currentAngleTV.setText("Current Angle: " + cannonAnimator.getCannonAngle() + " degrees.");
                return true;
            } else {
                return false;
            }
        }

    }

    private class decreaseAngleButtonListener implements Button.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(cannonAnimator.mainCannon.getDegAngle() > 0) {
                cannonAnimator.decreaseCannonAngle();
                currentAngleTV.setText("Current Angle: " + cannonAnimator.getCannonAngle() + " degrees.");
                return true;
            } else {
                return false;
            }
        }

    }

    private class fireButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            if(cannonAnimator.mainCannon.getCannonBallCount() > 0) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.blast);
                    }
                    mp.start();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                /**
                 External Citation
                 * Date: 9 April 2017
                 * Problem: Wanted to play sound on button press.
                 * Resource: http://stackoverflow.com/questions/18459122/
                             play-sound-on-button-click-android
                 * Solution: I used the example code that a user provided and adapted
                             it for my own use.
                 */

                cannonAnimator.fireCannon();
                notificationTV.setText("" + cannonAnimator.mainCannon.getCannonBallCount() + " balls left.");

            } else {
                notificationTV.setText("Game Over.");
                cannonAnimator.doPause();
            }
            for (Target t : cannonAnimator.targetList) {
                if (t.getIsHit() && !t.isScored()) {
                    t.score();
                    score += t.getPointWorth();
                    scoreboardTV.setText("Score: " + score + " points.");
                }
            }
        }

    }

    private class gravitySeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar gravitySeekBar, int i, boolean b) {
            gravityTV.setText("Gravity: " + gravitySeekBar.getProgress());
            if(cannonAnimator.ball == null) {
                cannonAnimator.mainCannon.setGravity(gravitySeekBar.getProgress());
                myCanvas.invalidate();
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {


        }
    }

}
