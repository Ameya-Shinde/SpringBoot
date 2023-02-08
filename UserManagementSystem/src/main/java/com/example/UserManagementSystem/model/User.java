package com.example.UserManagementSystem.model;

public class User {

    private int UserId;

    private String Name;

    private String UserName;

    private String Address;

    private String number;

    public int getUserId() {
        return UserId;
    }

    public User(int userId, String name, String userName, String address, String number) {
        this.UserId = userId;
        this.Name = name;
        this.UserName = userName;
        this.Address = address;
        this.number = number;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", Name='" + Name + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Address='" + Address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
