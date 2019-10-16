package com.haiph.apivanlang.model;

public class QuocGia {
    String tenQuocGia;

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public QuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    @Override
    public String toString() {
        return
                 tenQuocGia ;
    }
}
