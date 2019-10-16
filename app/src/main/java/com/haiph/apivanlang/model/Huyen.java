package com.haiph.apivanlang.model;

public class Huyen {
    String tenHuyen;

    @Override
    public String toString() {
        return  tenHuyen;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    public Huyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }
}
