package com.example.practical.entity;

public class Account {
    private String UserName;
    private String Password;

    public Account() {
    }

    public Account(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    @Override
    public String toString() {
        return "LoginTest{" +
                "UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
