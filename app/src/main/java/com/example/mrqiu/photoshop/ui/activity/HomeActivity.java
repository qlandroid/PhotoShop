package com.example.mrqiu.photoshop.ui.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mrqiu.photoshop.R;
import com.example.mrqiu.photoshop.info.BindView;
import com.example.mrqiu.photoshop.ui.BaseActivity;
import com.example.mrqiu.photoshop.ui.fragment.HomeFragment;
import com.example.mrqiu.photoshop.ui.widget.NavigationGroupView;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.home_ngv_btn)
    NavigationGroupView ngvBtn;

    private String[] names;
    private int[] normalIcon;
    private int[] selectIcon;
    private int normalColor;
    private int selectColor;

    private FragmentManager mFragmentManager;
    @Override
    public int initContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void initData() {
        super.initData();
        mFragmentManager = getSupportFragmentManager();
        names = new String[]{"点击1","点击2","点击3"};
        normalIcon = new int[]{
                android.R.drawable.ic_btn_speak_now,
                android.R.drawable.ic_btn_speak_now,
                android.R.drawable.ic_btn_speak_now
        };
        selectIcon = new int[]{
                R.drawable.login_pw,
                R.drawable.login_pw,
                R.drawable.login_pw
        };
        selectColor = R.color.colorAccent;
        normalColor = R.color.colorPrimaryDark;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        ngvBtn.setOnClickButtonListener(new NavigationGroupView.OnClickButtonListener() {
            @Override
            public void onClickSelectButton(int position) {
                mFragmentManager.beginTransaction().add(R.id.home_fl_content,HomeFragment.newInstance())
                        .commit();
            }
        });
        ngvBtn.setResources(names,normalColor,selectColor,selectIcon,normalIcon);
        ngvBtn.setSelectButton(0);
    }
}
