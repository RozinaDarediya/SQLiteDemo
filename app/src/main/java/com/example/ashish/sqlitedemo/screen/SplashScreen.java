package com.example.ashish.sqlitedemo.screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.ashish.sqlitedemo.R;
import com.example.ashish.sqlitedemo.screen.screen.AddDataActivity;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;
    Animation animation;
    private static final int SPLASH_TIME_MILLISEC = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imageView = (ImageView)findViewById(R.id.imageview);
        animation = AnimationUtils.loadAnimation(this,R.anim.hold);
        imageView.setAnimation(animation);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,AddDataActivity.class);
                startActivity(intent);
            }
        },SPLASH_TIME_MILLISEC);


    }
}
