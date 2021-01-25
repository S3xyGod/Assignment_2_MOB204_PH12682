package com.s3xygod.assignmentmob204_ph12682.model;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties

public class Members {
    private String userName;
    private String password;
    private String phone;
    private String hoTen;

    public Members() {
    }

    public Members(String userName, String password, String phone, String hoTen) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.hoTen = hoTen;
    }

    public Members(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    @Override
    public String toString() {
        return "NguoiDung{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", hoTen='" + hoTen + '\'' +
                '}';
    }
}
