package com.haiph.apivanlang.model;

public class Tinh   {
    String tenTinh;

    @Override
    public String toString() {
        return tenTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public Tinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }
}
