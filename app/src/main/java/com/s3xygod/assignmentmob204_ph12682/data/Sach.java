package com.s3xygod.assignmentmob204_ph12682.data;

import java.util.ArrayList;

public class Sach{
    private int id;
    private String nameBook, nameTL;
    private float giaTien;

    public Sach() {
    }

    public Sach(int id, String nameBook, String nameTL, float giaTien) {
        this.id = id;
        this.nameBook = nameBook;
        this.nameTL = nameTL;
        this.giaTien = giaTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getNameTL() {
        return nameTL;
    }

    public void setNameTL(String nameTL) {
        this.nameTL = nameTL;
    }

    public float getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(float giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", nameTL='" + nameTL + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }
}

