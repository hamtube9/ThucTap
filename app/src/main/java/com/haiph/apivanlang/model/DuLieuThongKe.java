package com.haiph.apivanlang.model;

public class DuLieuThongKe {

    String tenSuKien;

    public String getTenSuKien() {
        return tenSuKien;
    }

    public void setTenSuKien(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    public DuLieuThongKe(String tenSuKien) {
        this.tenSuKien = tenSuKien;
    }

    @Override
    public String toString() {
        return
                tenSuKien ;

    }
}
