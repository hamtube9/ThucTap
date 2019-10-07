
package com.haiph.apivanlang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token {

    @SerializedName("access_token")
    @Expose
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("idSoYeuLyLich")
    @Expose
    private String idSoYeuLyLich;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("hoVaTen")
    @Expose
    private String hoVaTen;
    @SerializedName("ma")
    @Expose
    private String ma;
    @SerializedName("ngonNgu")
    @Expose
    private String ngonNgu;
    @SerializedName("phapDanh")
    @Expose
    private String phapDanh;
    @SerializedName("soDienThoai")
    @Expose
    private String soDienThoai;
    @SerializedName("tenCoCauToChuc")
    @Expose
    private String tenCoCauToChuc;
    @SerializedName("ngaySinh")
    @Expose
    private String ngaySinh;
    @SerializedName("idCoCauToChuc")
    @Expose
    private String idCoCauToChuc;
    @SerializedName(".issued")
    @Expose
    private String issued;
    @SerializedName(".expires")
    @Expose
    private String expires;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSoYeuLyLich() {
        return idSoYeuLyLich;
    }

    public void setIdSoYeuLyLich(String idSoYeuLyLich) {
        this.idSoYeuLyLich = idSoYeuLyLich;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getPhapDanh() {
        return phapDanh;
    }

    public void setPhapDanh(String phapDanh) {
        this.phapDanh = phapDanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenCoCauToChuc() {
        return tenCoCauToChuc;
    }

    public void setTenCoCauToChuc(String tenCoCauToChuc) {
        this.tenCoCauToChuc = tenCoCauToChuc;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getIdCoCauToChuc() {
        return idCoCauToChuc;
    }

    public void setIdCoCauToChuc(String idCoCauToChuc) {
        this.idCoCauToChuc = idCoCauToChuc;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

}
