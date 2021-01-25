package com.s3xygod.assignmentmob204_ph12682.model;

public class Bill_Info {
    private int maHDCT;
    private Bill bill;
    private Sach sach;
    private int soLuongMua;

    public Bill_Info() {
    }

    public Bill_Info(int maHDCT, Bill bill, Sach sach, int soLuongMua) {
        this.maHDCT = maHDCT;
        this.bill = bill;
        this.sach = sach;
        this.soLuongMua = soLuongMua;
    }

    public int getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(int maHDCT) {
        this.maHDCT = maHDCT;
    }

    public Bill getHoaDon() {
        return bill;
    }

    public void setHoaDon(Bill hoaDon) {
        this.bill = hoaDon;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "maHDCT=" + maHDCT +
                ", hoaDon=" + bill.toString() +
                ", sach=" + sach.toString() +
                ", soLuongMua=" + soLuongMua +
                '}';
    }
}
