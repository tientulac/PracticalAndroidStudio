package com.example.practical.dto;

public class ResponseLogin {
    private String Token;
    private String Message;
    private Info Info;

    public ResponseLogin() {
    }

    public ResponseLogin(String token, String message, com.example.practical.dto.Info info) {
        Token = token;
        Message = message;
        Info = info;
    }

    @Override
    public String toString() {
        return "ResponseLogin{" +
                "Token='" + Token + '\'' +
                ", Message='" + Message + '\'' +
                ", Info=" + Info +
                '}';
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public com.example.practical.dto.Info getInfo() {
        return Info;
    }

    public void setInfo(com.example.practical.dto.Info info) {
        Info = info;
    }
}
