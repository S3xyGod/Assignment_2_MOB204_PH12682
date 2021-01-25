package com.s3xygod.assignmentmob204_ph12682.model;

import java.util.Date;

public class Bill {
    private String idBill;
    private Date ngayMuon;

    public Bill() {
    }

    public Bill(String idBill, Date ngayMuon) {
        this.idBill = idBill;
        this.ngayMuon = ngayMuon;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }


    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + idBill +
                ", ngayMuon='" + ngayMuon + '\'' +
                '}';
    }
}
