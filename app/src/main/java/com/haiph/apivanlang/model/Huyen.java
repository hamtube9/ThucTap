package com.haiph.apivanlang.model;

public class Huyen {
    String tenHuyen;
    int id;

    public Huyen(String tenHuyen, int id) {
        this.tenHuyen = tenHuyen;
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
