package com.haiph.apivanlang.model;

public class DuLieuThongKe {

    String tenSuKien;
    int id;

    public String getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DuLieuThongKe(String tenSuKien, int id) {
        this.tenSuKien = tenSuKien;
        this.id = id;
    }

    @Override
    public String toString() {
        return
                tenSuKien ;

    }
}
