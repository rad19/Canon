// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// 3 March 2017

package edu.up.rad19egr.canon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CannonMainActivity extends AppCompatActivity {

    private AnimationCanvas myCanvas;
    private CannonAnimator cannonAnimator;

    private Button increaseAngleButton;
    private Button decreaseAngleButton;
    private Button fireButton;

    private TextView currentAngleTV;
    private TextView notificationTV;
    private TextView scoreboardTV;

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
        increaseAngleButton.setOnClickListener(new increaseAngleButtonListener());
        decreaseAngleButton.setOnClickListener(new decreaseAngleButtonListener());
        fireButton.setOnClickListener(new fireButtonListener());

        currentAngleTV = (TextView)findViewById(R.id.cannonAngleTextView);
        notificationTV = (TextView)findViewById(R.id.notificationTextView);
        scoreboardTV = (TextView)findViewById(R.id.scoreboardTextView);
        currentAngleTV.setText("Current Angle: 45 Degrees");
        notificationTV.setText("" + cannonAnimator.mainCannon.getCannonBallCount() + " cannonballs left.");
        scoreboardTV.setText("Score: 0 Points");

        myCanvas.invalidate();

        mainLayout.invalidate();

    }

    private class increaseAngleButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            cannonAnimator.increaseCannonAngle();
            currentAngleTV.setText("Current Angle: " + cannonAnimator.getCannonAngle() + " degrees.");
        }

    }

    private class decreaseAngleButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            cannonAnimator.decreaseCannonAngle();
            currentAngleTV.setText("Current Angle: " + cannonAnimator.getCannonAngle() + " degrees.");
        }

    }

    private class fireButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            if(cannonAnimator.mainCannon.getCannonBallCount() > 0) {
                cannonAnimator.fireCannon();
                notificationTV.setText("" + cannonAnimator.mainCannon.getCannonBallCount() + " balls left.");
            } else {
                notificationTV.setText("Game Over.");
                cannonAnimator.doPause();
            }
        }
    }

}
