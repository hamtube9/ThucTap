
package com.haiph.apivanlang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("hoVaTen")
    @Expose
    private String hoVaTen;
    @SerializedName("maCoCauToChuc")
    @Expose
    private String maCoCauToChuc;
    @SerializedName("tenCoCauToChuc")
    @Expose
    private String tenCoCauToChuc;
    @SerializedName("diaChi")
    @Expose
    private String diaChi;
    @SerializedName("nguoiThan_DiaChi")
    @Expose
    private String nguoiThanDiaChi;
    @SerializedName("maQuocGia")
    @Expose
    private String maQuocGia;
    @SerializedName("tenQuocGia")
    @Expose
    private String tenQuocGia;
    @SerializedName("maXa")
    @Expose
    private String maXa;
    @SerializedName("nguoiThan_MaXa")
    @Expose
    private String nguoiThanMaXa;
    @SerializedName("maNguoiBaoLanh")
    @Expose
    private String maNguoiBaoLanh;
    @SerializedName("chon")
    @Expose
    private Boolean chon;
    @SerializedName("phanLoai")
    @Expose
    private String phanLoai;
    @SerializedName("tenGioiTinh")
    @Expose
    private String tenGioiTinh;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("anhDaiDien")
    @Expose
    private String anhDaiDien;
    @SerializedName("ma")
    @Expose
    private String ma;
    @SerializedName("idQuocGia")
    @Expose
    private Integer idQuocGia;
    @SerializedName("ho")
    @Expose
    private String ho;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("phapDanh")
    @Expose
    private String phapDanh;
    @SerializedName("gioiTinh")
    @Expose
    private Integer gioiTinh;
    @SerializedName("ngaySinh")
    @Expose
    private String ngaySinh;
    @SerializedName("soDienThoai")
    @Expose
    private String soDienThoai;
    @SerializedName("soNha")
    @Expose
    private String soNha;
    @SerializedName("idXa")
    @Expose
    private Integer idXa;
    @SerializedName("idHuyen")
    @Expose
    private Integer idHuyen;
    @SerializedName("idTinh")
    @Expose
    private Integer idTinh;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("ngheNghiep")
    @Expose
    private String ngheNghiep;
    @SerializedName("nguoiThan_HoVaTen")
    @Expose
    private String nguoiThanHoVaTen;
    @SerializedName("nguoiThan_SoDienThoai")
    @Expose
    private String nguoiThanSoDienThoai;
    @SerializedName("nguoiThan_SoNha")
    @Expose
    private String nguoiThanSoNha;
    @SerializedName("nguoiThan_IDXa")
    @Expose
    private Integer nguoiThanIDXa;
    @SerializedName("nguoiThan_IDHuyen")
    @Expose
    private Integer nguoiThanIDHuyen;
    @SerializedName("nguoiThan_IDTinh")
    @Expose
    private Integer nguoiThanIDTinh;
    @SerializedName("ghiChu")
    @Expose
    private String ghiChu;
    @SerializedName("idDonVi")
    @Expose
    private Integer idDonVi;
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
    @SerializedName("idNguoiBaoLanh")
    @Expose
    private Integer idNguoiBaoLanh;
    @SerializedName("nguoiBaoLanh")
    @Expose
    private String nguoiBaoLanh;
    @SerializedName("nguoiBaoLanh_SoDienThoai")
    @Expose
    private String nguoiBaoLanhSoDienThoai;
    @SerializedName("idCoCauToChuc")
    @Expose
    private Integer idCoCauToChuc;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("socmtnd")
    @Expose
    private String socmtnd;
    @SerializedName("linkAnhDaiDien")
    @Expose
    private String linkAnhDaiDien;
    @SerializedName("namSinh")
    @Expose
    private Integer namSinh;
    @SerializedName("ngayVaoChua")
    @Expose
    private String ngayVaoChua;
    @SerializedName("namVaoChua")
    @Expose
    private Integer namVaoChua;

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getMaCoCauToChuc() {
        return maCoCauToChuc;
    }

    public void setMaCoCauToChuc(String maCoCauToChuc) {
        this.maCoCauToChuc = maCoCauToChuc;
    }

    public String getTenCoCauToChuc() {
        return tenCoCauToChuc;
    }

    public void setTenCoCauToChuc(String tenCoCauToChuc) {
        this.tenCoCauToChuc = tenCoCauToChuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNguoiThanDiaChi() {
        return nguoiThanDiaChi;
    }

    public void setNguoiThanDiaChi(String nguoiThanDiaChi) {
        this.nguoiThanDiaChi = nguoiThanDiaChi;
    }

    public String getMaQuocGia() {
        return maQuocGia;
    }

    public void setMaQuocGia(String maQuocGia) {
        this.maQuocGia = maQuocGia;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }

    public String getMaXa() {
        return maXa;
    }

    public void setMaXa(String maXa) {
        this.maXa = maXa;
    }

    public String getNguoiThanMaXa() {
        return nguoiThanMaXa;
    }

    public void setNguoiThanMaXa(String nguoiThanMaXa) {
        this.nguoiThanMaXa = nguoiThanMaXa;
    }

    public String getMaNguoiBaoLanh() {
        return maNguoiBaoLanh;
    }

    public void setMaNguoiBaoLanh(String maNguoiBaoLanh) {
        this.maNguoiBaoLanh = maNguoiBaoLanh;
    }

    public Boolean getChon() {
        return chon;
    }

    public void setChon(Boolean chon) {
        this.chon = chon;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(String tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getIdQuocGia() {
        return idQuocGia;
    }

    public void setIdQuocGia(Integer idQuocGia) {
        this.idQuocGia = idQuocGia;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhapDanh() {
        return phapDanh;
    }

    public void setPhapDanh(String phapDanh) {
        this.phapDanh = phapDanh;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public Integer getIdXa() {
        return idXa;
    }

    public void setIdXa(Integer idXa) {
        this.idXa = idXa;
    }

    public Integer getIdHuyen() {
        return idHuyen;
    }

    public void setIdHuyen(Integer idHuyen) {
        this.idHuyen = idHuyen;
    }

    public Integer getIdTinh() {
        return idTinh;
    }

    public void setIdTinh(Integer idTinh) {
        this.idTinh = idTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getNguoiThanHoVaTen() {
        return nguoiThanHoVaTen;
    }

    public void setNguoiThanHoVaTen(String nguoiThanHoVaTen) {
        this.nguoiThanHoVaTen = nguoiThanHoVaTen;
    }

    public String getNguoiThanSoDienThoai() {
        return nguoiThanSoDienThoai;
    }

    public void setNguoiThanSoDienThoai(String nguoiThanSoDienThoai) {
        this.nguoiThanSoDienThoai = nguoiThanSoDienThoai;
    }

    public String getNguoiThanSoNha() {
        return nguoiThanSoNha;
    }

    public void setNguoiThanSoNha(String nguoiThanSoNha) {
        this.nguoiThanSoNha = nguoiThanSoNha;
    }

    public Integer getNguoiThanIDXa() {
        return nguoiThanIDXa;
    }

    public void setNguoiThanIDXa(Integer nguoiThanIDXa) {
        this.nguoiThanIDXa = nguoiThanIDXa;
    }

    public Integer getNguoiThanIDHuyen() {
        return nguoiThanIDHuyen;
    }

    public void setNguoiThanIDHuyen(Integer nguoiThanIDHuyen) {
        this.nguoiThanIDHuyen = nguoiThanIDHuyen;
    }

    public Integer getNguoiThanIDTinh() {
        return nguoiThanIDTinh;
    }

    public void setNguoiThanIDTinh(Integer nguoiThanIDTinh) {
        this.nguoiThanIDTinh = nguoiThanIDTinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public Integer getIdDonVi() {
        return idDonVi;
    }

    public void setIdDonVi(Integer idDonVi) {
        this.idDonVi = idDonVi;
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

    public Integer getIdNguoiBaoLanh() {
        return idNguoiBaoLanh;
    }

    public void setIdNguoiBaoLanh(Integer idNguoiBaoLanh) {
        this.idNguoiBaoLanh = idNguoiBaoLanh;
    }

    public String getNguoiBaoLanh() {
        return nguoiBaoLanh;
    }

    public void setNguoiBaoLanh(String nguoiBaoLanh) {
        this.nguoiBaoLanh = nguoiBaoLanh;
    }

    public String getNguoiBaoLanhSoDienThoai() {
        return nguoiBaoLanhSoDienThoai;
    }

    public void setNguoiBaoLanhSoDienThoai(String nguoiBaoLanhSoDienThoai) {
        this.nguoiBaoLanhSoDienThoai = nguoiBaoLanhSoDienThoai;
    }

    public Integer getIdCoCauToChuc() {
        return idCoCauToChuc;
    }

    public void setIdCoCauToChuc(Integer idCoCauToChuc) {
        this.idCoCauToChuc = idCoCauToChuc;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSocmtnd() {
        return socmtnd;
    }

    public void setSocmtnd(String socmtnd) {
        this.socmtnd = socmtnd;
    }

    public String getLinkAnhDaiDien() {
        return linkAnhDaiDien;
    }

    public void setLinkAnhDaiDien(String linkAnhDaiDien) {
        this.linkAnhDaiDien = linkAnhDaiDien;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public String getNgayVaoChua() {
        return ngayVaoChua;
    }

    public void setNgayVaoChua(String ngayVaoChua) {
        this.ngayVaoChua = ngayVaoChua;
    }

    public Integer getNamVaoChua() {
        return namVaoChua;
    }

    public void setNamVaoChua(Integer namVaoChua) {
        this.namVaoChua = namVaoChua;
    }

}
