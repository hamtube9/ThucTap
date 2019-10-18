package com.haiph.apivanlang.model;

public class Tinh   {
    String tenTinh;
    int id;

    public Tinh(String tenTinh, int id) {
        this.tenTinh = tenTinh;
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
