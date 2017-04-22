package com.example.mrqiu.photoshop.info;

import com.example.mrqiu.photoshop.C;
import com.example.mrqiu.photoshop.bean.A_ResultBean;
import com.example.mrqiu.photoshop.utils.DataUtils;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by mrqiu on 2017/4/22.
 */

public class HttpRun {

    private Class aClass;
    private String url;
    private Map<String,String> mHeader;
    private Map<String,Object> mParams;
    private Object  mTag;

    public HttpRun(Class aClass, String url, Map<String, String> mHeader, Map<String, Object> mParams, Object mTag) {
        this.aClass = aClass;
        this.url = url;
        this.mHeader = mHeader;
        this.mParams = mParams;
        this.mTag = mTag;
    }

    public void execute(final OnCallbackObjectListener listener){
        final OnCallbackObjectListener l = listener;
        OkHttpUtils.postString().mediaType(MediaType.parse("application/json"))
                .content(C.sGson.toJson(mParams))
                .url(url)
                .tag(mTag)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e)                        {
                        l.onFails(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        A_ResultBean resultBean = DataUtils.getObject(response, A_ResultBean.class);
                        if ("200".equals(resultBean.getCode())){
                            Object result = DataUtils.getDataObject(resultBean.getData(),aClass);
                            l.onSuccess(result);
                        }else {
                            Exception err = new MyErrorException(resultBean.getCode());
                            l.onFails(err);
                        }
                    }
                });
    }

    public void execute(OnCallbackListListener listener){
        final OnCallbackListListener l = listener;
        OkHttpUtils.postString().mediaType(MediaType.parse("application/json"))
                .content(C.sGson.toJson(mParams))
                .url(url)
                .tag(mTag)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e)                        {
                        l.onFails(e);
                    }

                    @Override
                    public void onResponse(String response) {
                        A_ResultBean resultBean = DataUtils.getObject(response, A_ResultBean.class);
                        if ("200".equals(resultBean.getCode())){
                            ArrayList resultList = DataUtils.getDataList(resultBean.getData(),aClass);
                            l.onSuccess(resultList);
                        }else {
                            Exception err = new MyErrorException(resultBean.getCode());
                            l.onFails(err);
                        }
                    }
                });
    }
}
