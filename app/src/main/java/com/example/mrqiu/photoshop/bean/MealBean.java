package com.example.mrqiu.photoshop.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class MealBean implements Parcelable {


    //{"createdAt":"2017-04-22 13:11:28",
    // "discount_price":299,
    private double discount_price;
    // "end_time":12345567999999,
    private long end_time;
    // "icon_cover":"www.baidu.com,www.youku.com","icons":"www.baidu.com",
    private String icon_cover;
    // "id":19,
    // "leve":1,
    private int leve;
    // "meal_collect_qty":0,
    private int meal_collect_qty;
    // "meal_introduce":"简介就是dddd我很便宜",
    private String meal_introduce;
    // "meal_name":"genggai",
    private String meal_name;
    // "meal_praise_qty":0,
    private int meal_praise_qty;
    // "normal_price":399,
    private double normal_price;
    // "objectId":"d556486035",
    private String objectId;
    // "ps_id":{"__type":"Pointer","className":"Photo_shop","objectId":"e4aa2f5af6"},
    private A_TypeBean ps_id;
    // "updatedAt":"2017-04-22 13:20:19",
    // "user_id":{"__type":"Pointer","className":"P_User","objectId":"CFIyR99H"}}
    private A_TypeBean user_id;
    private String icons;
    private String phone;
    private String describe;

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(double discount_price) {
        this.discount_price = discount_price;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
        this.end_time = end_time;
    }

    public String getIcon_cover() {
        return icon_cover;
    }

    public void setIcon_cover(String icon_cover) {
        this.icon_cover = icon_cover;
    }

    public int getLeve() {
        return leve;
    }

    public void setLeve(int leve) {
        this.leve = leve;
    }

    public int getMeal_collect_qty() {
        return meal_collect_qty;
    }

    public void setMeal_collect_qty(int meal_collect_qty) {
        this.meal_collect_qty = meal_collect_qty;
    }

    public String getMeal_introduce() {
        return meal_introduce;
    }

    public void setMeal_introduce(String meal_introduce) {
        this.meal_introduce = meal_introduce;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public int getMeal_praise_qty() {
        return meal_praise_qty;
    }

    public void setMeal_praise_qty(int meal_praise_qty) {
        this.meal_praise_qty = meal_praise_qty;
    }

    public double getNormal_price() {
        return normal_price;
    }

    public void setNormal_price(double normal_price) {
        this.normal_price = normal_price;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public A_TypeBean getPs_id() {
        return ps_id;
    }

    public void setPs_id(A_TypeBean ps_id) {
        this.ps_id = ps_id;
    }

    public A_TypeBean getUser_id() {
        return user_id;
    }

    public void setUser_id(A_TypeBean user_id) {
        this.user_id = user_id;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.discount_price);
        dest.writeLong(this.end_time);
        dest.writeString(this.icon_cover);
        dest.writeInt(this.leve);
        dest.writeInt(this.meal_collect_qty);
        dest.writeString(this.meal_introduce);
        dest.writeString(this.meal_name);
        dest.writeInt(this.meal_praise_qty);
        dest.writeDouble(this.normal_price);
        dest.writeString(this.objectId);
        dest.writeParcelable(this.ps_id, flags);
        dest.writeParcelable(this.user_id, flags);
        dest.writeString(this.icons);
        dest.writeString(this.phone);
        dest.writeString(this.describe);
    }

    public MealBean() {
    }

    protected MealBean(Parcel in) {
        this.discount_price = in.readDouble();
        this.end_time = in.readLong();
        this.icon_cover = in.readString();
        this.leve = in.readInt();
        this.meal_collect_qty = in.readInt();
        this.meal_introduce = in.readString();
        this.meal_name = in.readString();
        this.meal_praise_qty = in.readInt();
        this.normal_price = in.readDouble();
        this.objectId = in.readString();
        this.ps_id = in.readParcelable(A_TypeBean.class.getClassLoader());
        this.user_id = in.readParcelable(A_TypeBean.class.getClassLoader());
        this.icons = in.readString();
        this.phone = in.readString();
        this.describe = in.readString();
    }

    public static final Parcelable.Creator<MealBean> CREATOR = new Parcelable.Creator<MealBean>() {
        @Override
        public MealBean createFromParcel(Parcel source) {
            return new MealBean(source);
        }

        @Override
        public MealBean[] newArray(int size) {
            return new MealBean[size];
        }
    };
}
