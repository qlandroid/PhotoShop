package com.example.mrqiu.photoshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mrqiu.photoshop.info.UrlApi;
import com.example.mrqiu.photoshop.ui.activity.HomeActivity;
import com.example.mrqiu.photoshop.ui.activity.LoginActivity;
import com.example.mrqiu.photoshop.utils.LoginUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import cn.bmob.v3.AsyncCustomEndpoints;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.CloudCodeListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginUtils loginUtils = new LoginUtils();
        boolean isFirstLogin = loginUtils.isFirstLogin();
        /*if (isFirstLogin) {

            startActivity(new Intent(this, LoginActivity.class));
        } else {
            startActivity(new Intent(this, LoginActivity.class));
        }*/

    }

    public void toLogin(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void toHome(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
