package com.haiph.apivanlang.model;

public class PhatTu {
    String HoVaDem;
    String name;
    String phapDanh;
    String diachi;
    String dienthoai;
    String CMT;
    String id;
    String Email;
    String NgaySinh;
    String NguoiBaoLanh;
    String SDTNguoiBaoLanh;
    String NguoiThan;
    String SDTNguoiThan;
    String DiaChiNguoiThan;
    String gender;
    String QuocGia;
    String Tinh;
    String Quan;
    String Xa;
    String QuanNguoiThan;
    String XaNguoiThan;
    String ChuaHoatDong;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public PhatTu(String hoVaDem, String name, String phapDanh, String diachi, String dienthoai, String CMT, String id, String email, String ngaySinh, String nguoiBaoLanh, String SDTNguoiBaoLanh, String nguoiThan, String SDTNguoiThan, String diaChiNguoiThan, String gender, String quocGia, String tinh, String quan, String xa, String quanNguoiThan, String xaNguoiThan, String chuaHoatDong) {
        HoVaDem = hoVaDem;
        this.name = name;
        this.phapDanh = phapDanh;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.CMT = CMT;
        this.id = id;
        Email = email;
        NgaySinh = ngaySinh;
        NguoiBaoLanh = nguoiBaoLanh;
        this.SDTNguoiBaoLanh = SDTNguoiBaoLanh;
        NguoiThan = nguoiThan;
        this.SDTNguoiThan = SDTNguoiThan;
        DiaChiNguoiThan = diaChiNguoiThan;
        this.gender = gender;
        QuocGia = quocGia;
        Tinh = tinh;
        Quan = quan;
        Xa = xa;
        QuanNguoiThan = quanNguoiThan;
        XaNguoiThan = xaNguoiThan;
        ChuaHoatDong = chuaHoatDong;
    }

    public String getQuocGia() {
        return QuocGia;
    }

    public void setQuocGia(String quocGia) {
        QuocGia = quocGia;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String tinh) {
        Tinh = tinh;
    }

    public String getQuan() {
        return Quan;
    }

    public void setQuan(String quan) {
        Quan = quan;
    }

    public String getXa() {
        return Xa;
    }

    public void setXa(String xa) {
        Xa = xa;
    }

    public String getQuanNguoiThan() {
        return QuanNguoiThan;
    }

    public void setQuanNguoiThan(String quanNguoiThan) {
        QuanNguoiThan = quanNguoiThan;
    }

    public String getXaNguoiThan() {
        return XaNguoiThan;
    }

    public void setXaNguoiThan(String xaNguoiThan) {
        XaNguoiThan = xaNguoiThan;
    }

    public String getChuaHoatDong() {
        return ChuaHoatDong;
    }

    public void setChuaHoatDong(String chuaHoatDong) {
        ChuaHoatDong = chuaHoatDong;
    }

    public PhatTu(String name, String phapdanh, String diachi, String dienthoai, String cmt, String id) {
    }

    public String getSDTNguoiThan() {
        return SDTNguoiThan;
    }

    public void setSDTNguoiThan(String SDTNguoiThan) {
        this.SDTNguoiThan = SDTNguoiThan;
    }

    public String getHoVaDem() {
        return HoVaDem;
    }

    public void setHoVaDem(String hoVaDem) {
        HoVaDem = hoVaDem;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getNguoiBaoLanh() {
        return NguoiBaoLanh;
    }

    public void setNguoiBaoLanh(String nguoiBaoLanh) {
        NguoiBaoLanh = nguoiBaoLanh;
    }

    public String getSDTNguoiBaoLanh() {
        return SDTNguoiBaoLanh;
    }

    public void setSDTNguoiBaoLanh(String SDTNguoiBaoLanh) {
        this.SDTNguoiBaoLanh = SDTNguoiBaoLanh;
    }

    public String getNguoiThan() {
        return NguoiThan;
    }

    public void setNguoiThan(String nguoiThan) {
        NguoiThan = nguoiThan;
    }

    public String getDiaChiNguoiThan() {
        return DiaChiNguoiThan;
    }

    public void setDiaChiNguoiThan(String diaChiNguoiThan) {
        DiaChiNguoiThan = diaChiNguoiThan;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhapDanh() {
        return phapDanh;
    }

    public void setPhapDanh(String phapDanh) {
        this.phapDanh = phapDanh;
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

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }
}
