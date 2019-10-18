package com.haiph.apivanlang.model;

public class QuocGia {
    String tenQuocGia;
    int idQuocGia;

    public int getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(int idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public QuocGia(String tenQuocGia, int idQuocGia) {
        this.tenQuocGia = tenQuocGia;
        this.idQuocGia = idQuocGia;
    }

    public QuocGia(int idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    @Override
    public String toString() {
        return
                 tenQuocGia ;
    }


}
