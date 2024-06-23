package com.example.appqunlsinhvin.model;

public class Monhoc {

    //Các biến môn học

    // id môn học
    private int id;

    // tên môn học
    private String tenMonhoc;

    // Số tín chỉ
    private int soTinChi;

    // thời gian học
    private String timeHoc;

    // địa điểm
    private String diaDiem;

    public Monhoc() {
    }

    public Monhoc(String tenMonhoc, int soTinChi, String timeHoc, String diaDiem) {
        this.tenMonhoc = tenMonhoc;
        this.soTinChi = soTinChi;
        this.timeHoc = timeHoc;
        this.diaDiem = diaDiem;
    }

    public Monhoc(int id, String tenMonhoc, int soTinChi, String timeHoc, String diaDiem) {
        this.id = id;
        this.tenMonhoc = tenMonhoc;
        this.soTinChi = soTinChi;
        this.timeHoc = timeHoc;
        this.diaDiem = diaDiem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenMonhoc() {
        return tenMonhoc;
    }

    public void setTenMonhoc(String tenMonhoc) {
        this.tenMonhoc = tenMonhoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTimeHoc() {
        return timeHoc;
    }

    public void setTimeHoc(String timeHoc) {
        this.timeHoc = timeHoc;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }
}
