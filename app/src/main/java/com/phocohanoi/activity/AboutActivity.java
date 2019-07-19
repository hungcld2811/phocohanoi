package com.phocohanoi.activity;

import android.app.Activity;
import android.os.Bundle;

import com.phocohanoi.R;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        super.setUpDrawer();
    }
}
