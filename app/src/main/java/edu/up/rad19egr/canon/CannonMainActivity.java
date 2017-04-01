package edu.up.rad19egr.canon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CannonMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cannon_main);

        Animator canonAnimator = new CannonAnimator();
        AnimationCanvas myCanvas = new AnimationCanvas(this, canonAnimator);
        LinearLayout mainLayout = (LinearLayout) this.findViewById(R.id.activity_cannon_main);
        mainLayout.addView(myCanvas);



    }


}
