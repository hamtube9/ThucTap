package com.haiph.apivanlang.model;

public class ChuaHoatDong {
    String tenChua;
    int id;

    public ChuaHoatDong(String tenChua, int id) {
        this.tenChua = tenChua;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  tenChua ;
    }

    public String getTenChua() {
        return tenChua;
    }

    public void setTenChua(String tenChua) {
        this.tenChua = tenChua;
    }

    public ChuaHoatDong(String tenChua) {
        this.tenChua = tenChua;
    }
}
