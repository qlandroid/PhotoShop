package com.example.mrqiu.photoshop.ui.fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.View;

import com.example.mrqiu.photoshop.R;
import com.example.mrqiu.photoshop.info.BindView;
import com.example.mrqiu.photoshop.ui.BaseFragment;
import com.example.mrqiu.photoshop.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class HomeFragment extends BaseFragment {
    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @BindView(R.id.home_banner)
    Banner banner;

    @Override
    protected int initContentView() {
        return R.layout.frag_home;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget(View view) {
        super.initWidget(view);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3_000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {

            }
        });
    }
boolean isStart;
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        if (isStart) {
            banner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        isStart = true;
        //结束轮播
        banner.stopAutoPlay();
    }
}
