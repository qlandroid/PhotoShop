package com.example.mrqiu.photoshop.info;

import java.util.Map;
import java.util.Objects;

/**
 * Created by mrqiu on 2017/4/22.
 */

public abstract class ParamsBuilder {
    Class aClass;
    String url;
    Map<String, Object> mParams;
    Map<String, String> mHeader;
    Object mTag;

    public ParamsBuilder(Class aClass) {
        this.aClass = aClass;
    }
}
