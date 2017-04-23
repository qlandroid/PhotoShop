package com.example.mrqiu.photoshop.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mrqiu.photoshop.C;
import com.example.mrqiu.photoshop.R;
import com.example.mrqiu.photoshop.bean.IconTextBean;
import com.example.mrqiu.photoshop.bean.MealBean;
import com.example.mrqiu.photoshop.info.BindView;
import com.example.mrqiu.photoshop.info.MyErrorException;
import com.example.mrqiu.photoshop.info.OnCallbackListListener;
import com.example.mrqiu.photoshop.model.MealModel;
import com.example.mrqiu.photoshop.ui.BaseFragment;
import com.example.mrqiu.photoshop.ui.activity.MealActivity;
import com.example.mrqiu.photoshop.ui.adapter.RecyclerAdapter;
import com.example.mrqiu.photoshop.ui.widget.ImageButtonView;
import com.example.mrqiu.photoshop.utils.GlideImageLoader;
import com.example.mrqiu.photoshop.utils.RecyclerViewDivider;
import com.example.mrqiu.photoshop.utils.ToastUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_banner)
    Banner banner;
    @BindView(R.id.home_rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.home_rv_meal_list)
    RecyclerView rvMealList;

    private ArrayList<Integer> images;
    private ArrayList<IconTextBean> mMenuList;
    private ArrayList<MealBean> mMealList;

    private boolean isStart;

    private RecyclerAdapter<IconTextBean> mMenuAdapter;

    private RecyclerAdapter<MealBean> mMealAdapter;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int initContentView() {
        return R.layout.frag_home;
    }

    @Override
    public void initData() {
        super.initData();
        images = new ArrayList<>();
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);
        images.add(R.drawable.test_icon);
        images.add(R.drawable.test_icon_1);


        mMenuList = new ArrayList<>();
        mMenuList.add(new IconTextBean(R.drawable.home_menu_boy,"男生",0));
        mMenuList.add(new IconTextBean(R.drawable.home_menu_girl,"女生",2));
        mMenuList.add(new IconTextBean(R.drawable.home_menu_camera,"照相",1));
        mMenuList.add(new IconTextBean(R.drawable.home_menu_shop,"商店",3));
        mMenuList.add(new IconTextBean(R.drawable.home_menu_heart,"收藏",4));
        mMenuAdapter = new RecyclerAdapter<IconTextBean>(getActivity(),mMenuList,R.layout.item_menu_icon_text) {
            @Override
            public void onBindViewHolder(RViewHolder holder, IconTextBean iconTextBean, int position) {
                ImageButtonView ibv = holder.findView(R.id.item_icon_text);
                ibv.setImageViewIcon(iconTextBean.getIconId());
                ibv.setName(iconTextBean.getText());
            }
        };
        mMenuAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position, View v) {
                switch (mMenuList.get(position).getTag()){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });

        mMealAdapter = new RecyclerAdapter<MealBean>(getActivity(),null,R.layout.item_meal_icon) {
            @Override
            public void onBindViewHolder(RViewHolder holder, MealBean mealBean, int position) {
                Glide.with(HomeFragment.this)
                        .load(mealBean.getIcon_cover())
                        .into((ImageView) holder.findView(R.id.item_meal_iv_icon));
                holder.setText(R.id.item_meal_tv_title,mealBean.getMeal_introduce());
            }
        };
        mMealAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void itemClick(int position, View v) {
                Intent intent = new Intent(getActivity(), MealActivity.class);
                intent.putExtra(C.sType,C.Type.Type0);
                intent.putExtra(C.P,mMealList.get(position));
                startActivity(intent);

            }
        });

        MealModel.meal("黑龙江", "哈尔滨市", 1, 10, new OnCallbackListListener<MealBean>() {
            @Override
            public void onSuccess(ArrayList<MealBean> list) {
                mMealList = list;
                mMealAdapter.update(mMealList);
            }

            @Override
            public void onFails(Exception e) {
                if (e instanceof MyErrorException){
                    MyErrorException error = (MyErrorException) e;
                    ToastUtils.toast(getContext(),error.getMessage());
                }else if (e instanceof TimeoutException){
                    ToastUtils.toast(getContext(),"连接超时");
                }else {
                    ToastUtils.toast(getContext(),"系统错误");
                }
            }
        });
    }

    @Override
    public void initWidget(View view) {
        super.initWidget(view);

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

        rvMenu.setLayoutManager(new GridLayoutManager(getActivity(),5));
        rvMenu.setAdapter(mMenuAdapter);

        rvMealList.setLayoutManager(new LinearLayoutManager(getActivity()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvMealList.setAdapter(mMealAdapter);
        rvMealList.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.VERTICAL
                , (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,8,getResources().getDisplayMetrics())
                , ContextCompat.getColor(getActivity(),R.color.colorNull)));
    }


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
