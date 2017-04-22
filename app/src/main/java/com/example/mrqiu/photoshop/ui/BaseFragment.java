package com.example.mrqiu.photoshop.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mrqiu.photoshop.info.BindViewUtils;

/**
 * Created by mrqiu on 2017/4/22.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(initContentView(),container,false);
    }
    protected abstract int initContentView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initData();
        BindViewUtils.initView(this,view);
        initWidget(view);
    }

    public void initData(){};
    public void initWidget(View view){}
}
