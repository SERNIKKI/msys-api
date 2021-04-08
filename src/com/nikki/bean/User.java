package com.nikki.bean;

public class User {
    private String _openid;
    private String uname;
    private String email;

    public User() {
    }

    public User(String _openid, String uname, String email) {
        this._openid = _openid;
        this.uname = uname;
        this.email = email;
    }

    public String get_openid() {
        return _openid;
    }

    public void set_openid(String _openid) {
        this._openid = _openid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "_openid='" + _openid + '\'' +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
