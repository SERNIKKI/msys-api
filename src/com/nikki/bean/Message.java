package com.nikki.bean;

public class Message {
    private int id;
    private String _openid;
    private int S_id;
    private String message;
    private String date;
    private String user_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String get_openid() {
        return _openid;
    }

    public void set_openid(String _openid) {
        this._openid = _openid;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "message{" +
                "id=" + id +
                ", _openid='" + _openid + '\'' +
                ", S_id=" + S_id +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
