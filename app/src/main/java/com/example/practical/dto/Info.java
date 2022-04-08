package com.example.practical.dto;

public class Info {
    private String UserName;
    private int UserID;
    private String Email;
    private String FullName;

    public Info() {
    }

    public Info(String userName, int userID, String email, String fullName) {
        UserName = userName;
        UserID = userID;
        Email = email;
        FullName = fullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    @Override
    public String toString() {
        return "Info{" +
                "UserName='" + UserName + '\'' +
                ", UserID=" + UserID +
                ", Email='" + Email + '\'' +
                ", FullName='" + FullName + '\'' +
                '}';
    }
}
