package com.example.mrqiu.photoshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mrqiu.photoshop.ui.activity.HomeActivity;
import com.example.mrqiu.photoshop.ui.activity.LoginActivity;
import com.example.mrqiu.photoshop.utils.LoginUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        C.sUiWidth = getResources().getDisplayMetrics().widthPixels;
        C.sUiHeight = getResources().getDisplayMetrics().heightPixels;

        LoginUtils loginUtils = new LoginUtils();
        boolean isFirstLogin = loginUtils.isFirstLogin();
        /*if (isFirstLogin) {

            startActivity(new Intent(this, LoginActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }*/

    }

    public void toLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void toHome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
