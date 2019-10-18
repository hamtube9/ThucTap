package com.haiph.apivanlang.model;

public class Xa {
    String tenXa;
    int id;

    public Xa(String tenXa, int id) {
        this.tenXa = tenXa;
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
