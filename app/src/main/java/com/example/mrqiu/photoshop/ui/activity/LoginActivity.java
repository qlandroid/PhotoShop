package com.example.mrqiu.photoshop.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrqiu.photoshop.R;
import com.example.mrqiu.photoshop.info.BindView;
import com.example.mrqiu.photoshop.ui.BaseActivity;
import com.example.mrqiu.photoshop.utils.FastBlur;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_tv_zc)
    private TextView tvZc;
    @BindView(R.id.login_tv_wjmm)
    TextView tvWjmm;
    @BindView(R.id.login_btn_login)
    Button btnLogin;
    @BindView(R.id.login_et_account)
    EditText etAccount;
    @BindView(R.id.login_et_pw)
    EditText etPw;
    @BindView(R.id.iv)
    ImageView l;

    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initWidget() {
        super.initWidget();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.login_bg_0);
        bitmap = FastBlur.doBlur(bitmap,10,false);
        l.setImageBitmap(bitmap);
    }
}
