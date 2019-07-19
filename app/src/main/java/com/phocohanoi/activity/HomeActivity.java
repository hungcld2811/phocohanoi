package com.phocohanoi.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.infideap.drawerbehavior.Advance3DDrawerLayout;
import com.phocohanoi.R;
import com.phocohanoi.fragment.AboutFragment;
import com.phocohanoi.fragment.HomeFragment;
import com.phocohanoi.fragment.MapFragment;
import com.phocohanoi.fragment.ListViewFragment;
import com.phocohanoi.fragment.UtilFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Advance3DDrawerLayout drawer;
    private Button btnMap, btnList;
    private ImageView iconLeft;
    private TextView tvTest;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private RelativeLayout rlHome, rlAbout, rlUtil, rlLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        iconLeft = (ImageView) findViewById(R.id.iconLeft);
//        iconLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawer.openDrawer(GravityCompat.START);
//            }
//        });

        drawer = (Advance3DDrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        drawer.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getBackground().setColorFilter(0x00000000, PorterDuff.Mode.MULTIPLY);
        drawer.setViewScale(Gravity.START, 0.96f);
        drawer.setRadius(Gravity.START, 20);
        drawer.setViewElevation(Gravity.START, 8);
        drawer.setViewRotation(Gravity.START, 15);


//        btnMap = (Button) findViewById(R.id.btnMap);
//        btnList = (Button) findViewById(R.id.btnList);
        rlHome = (RelativeLayout) findViewById(R.id.rlHome);
        rlAbout = (RelativeLayout) findViewById(R.id.rlAbout);
        rlUtil = (RelativeLayout) findViewById(R.id.rlUtil);
        rlLanguage = (RelativeLayout) findViewById(R.id.rlLanguage);
        rlUtil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
                Fragment fragment = new UtilFragment();
                displaySelectedFragment(fragment);
            }
        });

        rlAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
//                Fragment fragment = new AboutFragment();
//                displaySelectedFragment(fragment);
                addFragment(new AboutFragment(), false, "one");
            }
        });

        rlHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
//                Fragment fragment = new HomeFragment();
//                displaySelectedFragment(fragment);
                addFragment(new HomeFragment(), false, "one");
            }
        });

        rlLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });
//        btnList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addFragment(new ListViewFragment(), false, "one");
//            }
//        });
//
//        btnMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addFragment(new MapFragment(), false, "one");
//            }
//        });

//        addFragment(new MapFragment(), false, "one");


//        Fragment fragment = new HomeFragment();
//        displaySelectedFragment(fragment);
        addFragment(new HomeFragment(), false, "one");
    }

    private void initView() {

    }

    private void initClickListener() {

    }

    private void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.container_frame_back, fragment, tag);
        ft.commitAllowingStateLoss();
    }

    private void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_frame_back, fragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
