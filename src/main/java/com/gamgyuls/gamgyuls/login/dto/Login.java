package com.gamgyuls.gamgyuls.login.dto;

public class Login {

    private String userId;    // User ID
    private String pwd;       // Password

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Login(String userId, String pwd) {
        this.userId = userId;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId='" + userId + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}