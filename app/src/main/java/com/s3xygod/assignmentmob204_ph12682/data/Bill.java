package com.s3xygod.assignmentmob204_ph12682.data;

import java.util.Date;

public class Bill {
    int id;
    String nameMem, nameSach, ngayMuon;

    public Bill() {
    }

    public Bill(int id, String nameMem, String nameSach, String ngayMuon) {
        this.id = id;
        this.nameMem = nameMem;
        this.nameSach = nameSach;
        this.ngayMuon = ngayMuon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMem() {
        return nameMem;
    }

    public void setNameMem(String nameMem) {
        this.nameMem = nameMem;
    }

    public String getNameSach() {
        return nameSach;
    }

    public void setNameSach(String nameSach) {
        this.nameSach = nameSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", nameMem='" + nameMem + '\'' +
                ", nameSach='" + nameSach + '\'' +
                ", ngayMuon=" + ngayMuon +
                '}';
    }
}
