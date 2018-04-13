package com.sc.bean;

public class Users {
    private String userId;
    private String  email;
    private String passWd;
    private String phone;
    private String userName;
    private int type;
    private String address;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                ", passWd='" + passWd + '\'' +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                ", type=" + type +
                ", address='" + address + '\'' +
                '}';
    }
}
