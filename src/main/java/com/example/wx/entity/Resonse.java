package com.example.wx.entity;

public class Resonse {
    private String tips;
    private Object object;

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Resonse(String tips, Object object) {
        this.tips = tips;
        this.object = object;
    }

    public Resonse() {
    }
}
