package com.haiph.apivanlang.model;

public class ChuaHoatDong {
    String tenChua;

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
