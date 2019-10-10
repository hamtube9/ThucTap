package com.haiph.apivanlang.model;

public class PhatTu {
    String name;
    String id;
    String diachi;
    String dienthoai;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public PhatTu(String name, String id, String diachi, String dienthoai) {
        this.name = name;
        this.id = id;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
    }


}
