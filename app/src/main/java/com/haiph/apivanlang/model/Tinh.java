package com.haiph.apivanlang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tinh   {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ma")
    @Expose
    private String ma;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("ghiChu")
    @Expose
    private Object ghiChu;
    @SerializedName("inUsed")
    @Expose
    private Boolean inUsed;
    @SerializedName("createdBy")
    @Expose
    private Integer createdBy;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("editedBy")
    @Expose
    private Object editedBy;
    @SerializedName("editedOn")
    @Expose
    private String editedOn;
    @SerializedName("idQuocGia")
    @Expose
    private Integer idQuocGia;
    @SerializedName("tenQuocGia")
    @Expose
    private String tenQuocGia;
    @SerializedName("maQuocGia")
    @Expose
    private String maQuocGia;


    @Override
    public String toString() {
        return ten;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Object getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(Object ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Boolean getInUsed() {
        return inUsed;
    }

    public void setInUsed(Boolean inUsed) {
        this.inUsed = inUsed;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Object getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Object editedBy) {
        this.editedBy = editedBy;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(String editedOn) {
        this.editedOn = editedOn;
    }

    public Integer getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(Integer idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }
}
