package com.phocohanoi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.phocohanoi.R;

public class SplashActivity extends Activity {

    private Handler changeBackground, goToHome;
    private ImageView imgBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imgBackground = (ImageView) findViewById(R.id.imgBackground);

        changeBackground = new Handler();
        changeBackground.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(getApplicationContext())
                        .load(R.mipmap.splash)
                        .into(imgBackground);
            }
        }, 1500);

        goToHome = new Handler();
        goToHome.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToHome();

            }
        }, 2500);


    }

    private void goToHome() {
        Intent home = new Intent(this, HomeActivity.class);
        home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
    }


}
