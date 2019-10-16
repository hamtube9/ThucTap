package com.haiph.apivanlang.model;

public class Xa {
    String tenXa;

    @Override
    public String toString() {
        return tenXa ;
    }

    public String getTenXa() {
        return tenXa;
    }

    public void setTenXa(String tenXa) {
        this.tenXa = tenXa;
    }

    public Xa(String tenXa) {
        this.tenXa = tenXa;
    }
}
