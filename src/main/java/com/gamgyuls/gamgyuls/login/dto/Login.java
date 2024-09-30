package com.gamgyuls.gamgyuls.login.dto;

public class Login {

    private String user_id;    // User ID
    private String pwd;       // Password

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Login(String user_id, String pwd) {
        this.user_id = user_id;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userId='" + user_id + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}