package com.haiph.apivanlang.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xa {
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
    private String ghiChu;
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
    private Integer editedBy;
    @SerializedName("editedOn")
    @Expose
    private String editedOn;
    @SerializedName("idHuyen")
    @Expose
    private Integer idHuyen;
    @SerializedName("tenHuyen")
    @Expose
    private String tenHuyen;
    @SerializedName("maHuyen")
    @Expose
    private String maHuyen;
    @SerializedName("idTinh")
    @Expose
    private Integer idTinh;
    @SerializedName("maTinh")
    @Expose
    private String maTinh;
    @SerializedName("tenTinh")
    @Expose
    private String tenTinh;
    @SerializedName("diaChi")
    @Expose
    private Object diaChi;

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

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
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

    public Integer getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(Integer editedBy) {
        this.editedBy = editedBy;
    }

    public String getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(String editedOn) {
        this.editedOn = editedOn;
    }

    public Integer getIdHuyen() {
        return idHuyen;
    }

    public void setIdHuyen(Integer idHuyen) {
        this.idHuyen = idHuyen;
    }

    public String getTenHuyen() {
        return tenHuyen;
    }

    public void setTenHuyen(String tenHuyen) {
        this.tenHuyen = tenHuyen;
    }

    public String getMaHuyen() {
        return maHuyen;
    }

    public void setMaHuyen(String maHuyen) {
        this.maHuyen = maHuyen;
    }

    public Integer getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(Integer idTinh) {
        this.idTinh = idTinh;
    }

    public String getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(String maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return tenTinh;
    }

    public void setTenTinh(String tenTinh) {
        this.tenTinh = tenTinh;
    }

    public Object getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(Object diaChi) {
        this.diaChi = diaChi;
    }

    @NonNull
    @Override
    public String toString() {

        return ten;
    }
}
