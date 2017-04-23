package com.example.mrqiu.photoshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class A_TypeBean implements Parcelable {
    //{"__type":"Pointer","className":"P_User","objectId":"CFIyR99H"}}
    private String _type;
    private String className;
    private String objectId;

    public A_TypeBean() {
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._type);
        dest.writeString(this.className);
        dest.writeString(this.objectId);
    }

    protected A_TypeBean(Parcel in) {
        this._type = in.readString();
        this.className = in.readString();
        this.objectId = in.readString();
    }

    public static final Parcelable.Creator<A_TypeBean> CREATOR = new Parcelable.Creator<A_TypeBean>() {
        @Override
        public A_TypeBean createFromParcel(Parcel source) {
            return new A_TypeBean(source);
        }

        @Override
        public A_TypeBean[] newArray(int size) {
            return new A_TypeBean[size];
        }
    };
}
