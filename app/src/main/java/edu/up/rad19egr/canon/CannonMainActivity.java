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
    private Animator cannonAnimator;
    private Button increaseAngleButton;
    private Button decreaseAngleButton;
    private Button fireButton;
    private TextView currentAngleTV;
    private TextView notificationTV;
    private TextView scoreboardTV;
    private Cannon cannon;

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
        notificationTV.setText("No notification to display.");
        scoreboardTV.setText("Score: 0 Points");

        cannon = new Cannon();

        myCanvas.invalidate();

        mainLayout.invalidate();


    }

    private class increaseAngleButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {
            cannon.increaseAngle();
            currentAngleTV.setText("Current Angle: " + (int)cannon.getCurrentAngle() + " degrees.");
        }


    }

    private class decreaseAngleButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {

        }


    }

    private class fireButtonListener implements Button.OnClickListener {

        @Override
        public void onClick(View v) {

        }


    }

}
