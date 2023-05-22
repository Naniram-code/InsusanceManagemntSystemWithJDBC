package com.pms.model;

public class UserList {
    public UserList() {
        super();
    }
    public static String Aemail="admin";
    public static String Apassword="admin";
    private int uid;
    private String uname;
    private String address;
    private long phone;
    private String email;
    private String password;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public UserList(int uid, String uname, String address, long phone, String email, String password) {
        this.uid = uid;
        this.uname = uname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }



    public UserList(int uid, String uname, String address, long phone, String email, String password, String status) {
        this.uid = uid;
        this.uname = uname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public UserList(String uname, String address, long phone, String email, String password) {
        this.uname = uname;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}





