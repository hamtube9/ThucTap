
package com.haiph.apivanlang.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("hoVaTen")
    @Expose
    private String hoVaTen;
    @SerializedName("maCoCauToChuc")
    @Expose
    private Object maCoCauToChuc;
    @SerializedName("tenCoCauToChuc")
    @Expose
    private Object tenCoCauToChuc;
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
    private Object maXa;
    @SerializedName("nguoiThan_MaXa")
    @Expose
    private Object nguoiThanMaXa;
    @SerializedName("maNguoiBaoLanh")
    @Expose
    private Object maNguoiBaoLanh;
    @SerializedName("chon")
    @Expose
    private Boolean chon;
    @SerializedName("phanLoai")
    @Expose
    private Object phanLoai;
    @SerializedName("tenGioiTinh")
    @Expose
    private Object tenGioiTinh;
    @SerializedName("anh")
    @Expose
    private Object anh;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("anhDaiDien")
    @Expose
    private Object anhDaiDien;
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
    private Object phapDanh;
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
    private Object soNha;
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
    private Object ngheNghiep;
    @SerializedName("nguoiThan_HoVaTen")
    @Expose
    private Object nguoiThanHoVaTen;
    @SerializedName("nguoiThan_SoDienThoai")
    @Expose
    private Object nguoiThanSoDienThoai;
    @SerializedName("nguoiThan_SoNha")
    @Expose
    private Object nguoiThanSoNha;
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
    private Object ghiChu;
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
    private Object editedOn;
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
    private Object ngayVaoChua;
    @SerializedName("namVaoChua")
    @Expose
    private Object namVaoChua;
    @SerializedName("isChuyenThanhTangNi")
    @Expose
    private Object isChuyenThanhTangNi;
    @SerializedName("thoiDiemChuyenTangNi")
    @Expose
    private Object thoiDiemChuyenTangNi;

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Object getMaCoCauToChuc() {
        return maCoCauToChuc;
    }

    public void setMaCoCauToChuc(Object maCoCauToChuc) {
        this.maCoCauToChuc = maCoCauToChuc;
    }

    public Object getTenCoCauToChuc() {
        return tenCoCauToChuc;
    }

    public void setTenCoCauToChuc(Object tenCoCauToChuc) {
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

    public Object getMaXa() {
        return maXa;
    }

    public void setMaXa(Object maXa) {
        this.maXa = maXa;
    }

    public Object getNguoiThanMaXa() {
        return nguoiThanMaXa;
    }

    public void setNguoiThanMaXa(Object nguoiThanMaXa) {
        this.nguoiThanMaXa = nguoiThanMaXa;
    }

    public Object getMaNguoiBaoLanh() {
        return maNguoiBaoLanh;
    }

    public void setMaNguoiBaoLanh(Object maNguoiBaoLanh) {
        this.maNguoiBaoLanh = maNguoiBaoLanh;
    }

    public Boolean getChon() {
        return chon;
    }

    public void setChon(Boolean chon) {
        this.chon = chon;
    }

    public Object getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(Object phanLoai) {
        this.phanLoai = phanLoai;
    }

    public Object getTenGioiTinh() {
        return tenGioiTinh;
    }

    public void setTenGioiTinh(Object tenGioiTinh) {
        this.tenGioiTinh = tenGioiTinh;
    }

    public Object getAnh() {
        return anh;
    }

    public void setAnh(Object anh) {
        this.anh = anh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(Object anhDaiDien) {
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

    public Object getPhapDanh() {
        return phapDanh;
    }

    public void setPhapDanh(Object phapDanh) {
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

    public Object getSoNha() {
        return soNha;
    }

    public void setSoNha(Object soNha) {
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

    public Object getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(Object ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public Object getNguoiThanHoVaTen() {
        return nguoiThanHoVaTen;
    }

    public void setNguoiThanHoVaTen(Object nguoiThanHoVaTen) {
        this.nguoiThanHoVaTen = nguoiThanHoVaTen;
    }

    public Object getNguoiThanSoDienThoai() {
        return nguoiThanSoDienThoai;
    }

    public void setNguoiThanSoDienThoai(Object nguoiThanSoDienThoai) {
        this.nguoiThanSoDienThoai = nguoiThanSoDienThoai;
    }

    public Object getNguoiThanSoNha() {
        return nguoiThanSoNha;
    }

    public void setNguoiThanSoNha(Object nguoiThanSoNha) {
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

    public Object getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(Object ghiChu) {
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

    public Object getEditedOn() {
        return editedOn;
    }

    public void setEditedOn(Object editedOn) {
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

    public Object getNgayVaoChua() {
        return ngayVaoChua;
    }

    public void setNgayVaoChua(Object ngayVaoChua) {
        this.ngayVaoChua = ngayVaoChua;
    }

    public Object getNamVaoChua() {
        return namVaoChua;
    }

    public void setNamVaoChua(Object namVaoChua) {
        this.namVaoChua = namVaoChua;
    }

    public Object getIsChuyenThanhTangNi() {
        return isChuyenThanhTangNi;
    }

    public void setIsChuyenThanhTangNi(Object isChuyenThanhTangNi) {
        this.isChuyenThanhTangNi = isChuyenThanhTangNi;
    }

    public Object getThoiDiemChuyenTangNi() {
        return thoiDiemChuyenTangNi;
    }

    public void setThoiDiemChuyenTangNi(Object thoiDiemChuyenTangNi) {
        this.thoiDiemChuyenTangNi = thoiDiemChuyenTangNi;
    }

}
