package com.haiph.apivanlang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Huyen {
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
    @SerializedName("idTinh")
    @Expose
    private Integer idTinh;
    @SerializedName("tenTinh")
    @Expose
    private String tenTinh;
    @SerializedName("maTinh")
    @Expose
    private String maTinh;

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

    public Integer getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(Integer idTinh) {
        this.idTinh = idTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    @Override
    public String toString() {
        return  ten ;
    }
}
