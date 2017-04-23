package com.example.mrqiu.photoshop.bean;

/**
 * Created by mrqiu on 2017/4/23.
 */

public class IconTextBean {
    private int iconId;
    private String text;

    private int tag;

    public IconTextBean(int iconId, String text, int tag) {
        this.iconId = iconId;
        this.text = text;
        this.tag = tag;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public IconTextBean(int iconId) {
        this.iconId = iconId;
    }

    public IconTextBean(int iconId, String text) {
        this.iconId = iconId;
        this.text = text;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
