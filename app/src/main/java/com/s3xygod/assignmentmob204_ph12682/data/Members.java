package com.s3xygod.assignmentmob204_ph12682.data;

public class Members {
    int id;
    String name, pass, sdt, add;

    public Members() {
    }

    public Members(int id, String name, String pass, String sdt, String add) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.sdt = sdt;
        this.add = add;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sdt='" + sdt + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
