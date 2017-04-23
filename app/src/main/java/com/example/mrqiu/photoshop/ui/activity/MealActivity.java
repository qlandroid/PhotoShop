package com.example.mrqiu.photoshop.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.example.mrqiu.photoshop.C;
import com.example.mrqiu.photoshop.R;
import com.example.mrqiu.photoshop.bean.MealBean;
import com.example.mrqiu.photoshop.info.BindView;
import com.example.mrqiu.photoshop.ui.BaseActivity;
import com.example.mrqiu.photoshop.ui.adapter.RecyclerAdapter;
import com.example.mrqiu.photoshop.utils.StringUtils;

import java.util.ArrayList;

public class MealActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.meal_ib_back)
    ImageButton ibBack;
    @BindView(R.id.meal_tv_title)
    TextView tvTitle;
    @BindView(R.id.meal_iv_icon_cover)
    ImageView ivCover;
    @BindView(R.id.meal_tv_price_normal)
    TextView tvPriceNormal;
    @BindView(R.id.meal_tv_collect_qty)
    TextView tvCollectQty;
    @BindView(R.id.meal_tv_price)
    TextView tvPrice;
    @BindView(R.id.meal_iv_collect)
    ImageView ivCollect;
    @BindView(R.id.meal_tv_name)
    TextView tvName;
    @BindView(R.id.meal_tv_introduce)
    TextView tvIntroduce;//简介
    @BindView(R.id.meal_tv_describe)
    TextView tvDescribe;//详细信息
    @BindView(R.id.meal_rv_icons)
    RecyclerView rvIcons;
    @BindView(R.id.meal_btn_to_shop)
    Button btnToShop;
    @BindView(R.id.meal_btn_to_phone)
    Button btnToPhone;
    @BindView(R.id.meal_ll_collect)
    View llCollect;

    private MealBean mMealBean;
    private ArrayList<String> mIconList;

    private RecyclerAdapter<String> mIconAdapter;
    private String mType;

    @Override
    public int initContentView() {
        return R.layout.activity_meal;
    }

    @Override
    public void initData() {
        super.initData();

        Intent intent = getIntent();
        mType = intent.getStringExtra(C.sType);
        switch (mType) {
            case C.Type.Type0:
                mMealBean = intent.getParcelableExtra(C.P);
                break;
        }
        mIconAdapter = new RecyclerAdapter<String>(this, null, R.layout.item_meal_img) {
            @Override
            public void onBindViewHolder(RViewHolder holder, String s, final int position) {
                final ImageView iv = holder.findView(R.id.item_iv_big);
                Glide.with(MealActivity.this).load(s).asBitmap().into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        int height = resource.getHeight();
                        int width = resource.getWidth();
                        float scale = width / (height * 1.0f);
                        int ivHeight = (int)(C.sUiWidth / scale);
                        ViewGroup.LayoutParams lp = iv.getLayoutParams();
                        lp.height= ivHeight;
                        iv.setLayoutParams(lp);
                        iv.setImageBitmap(resource);
                    }
                });
            }
        };
    }

    @Override
    public void initWidget() {
        super.initWidget();
        rvIcons.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rvIcons.setAdapter(mIconAdapter);

        ibBack.setOnClickListener(this);
        btnToPhone.setOnClickListener(this);
        btnToShop.setOnClickListener(this);
        llCollect.setOnClickListener(this);

        switch (mType) {
            case C.Type.Type0:
                showView();
                break;
        }
    }

    private void showView() {

        tvCollectQty.setText(String.valueOf(mMealBean.getMeal_collect_qty()));
        tvDescribe.setText(mMealBean.getDescribe());
        tvName.setText(mMealBean.getMeal_name());
        tvTitle.setText(mMealBean.getMeal_name());
        tvIntroduce.setText(mMealBean.getMeal_introduce());
        tvPrice.setText(String.valueOf(mMealBean.getDiscount_price()));
        tvPriceNormal.setText("¥"+String.valueOf(mMealBean.getNormal_price()));
        tvPriceNormal.getPaint().setFlags(Paint.SUBPIXEL_TEXT_FLAG);
        Glide.with(this).load(mMealBean.getIcon_cover())
                .placeholder(R.drawable.test_icon)
                .error(R.drawable.test_icon_1)
                .into(ivCover);

        String icons = mMealBean.getIcons();
        String[] iconsL = icons.split(",");
        if (iconsL != null && iconsL.length > 0) {
            mIconList = new ArrayList<>();
            for (String iconPath : iconsL) {
                if (!StringUtils.isEmpty(iconPath)) {
                    mIconList.add(iconPath);
                }
            }
            mIconAdapter.update(mIconList);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.meal_ll_collect:
                break;
            case R.id.meal_btn_to_phone:
                break;
            case R.id.meal_ib_back:
                break;
            case R.id.meal_btn_to_shop:
                break;
        }

    }
}
