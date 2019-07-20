package com.vivek.calculatorusinglottielibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;


public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lav=(LottieAnimationView)findViewById(R.id.animation_view);

        lav.addAnimatorUpdateListener((animation) -> {
            // Do something.
            lav.setRepeatCount(1);
            changeActivity();

        });
        lav.playAnimation();
        if (lav.isAnimating()) {

        }

        lav.setProgress(0.5f);

    }
    protected void changeActivity () {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }

}
