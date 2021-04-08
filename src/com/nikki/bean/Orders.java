package com.nikki.bean;

import java.util.List;

public class Orders {
    private String _id;
    private String _openid;
    private String date;
    private List<Goods> food;
    private int price;
    private int state;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_openid() {
        return _openid;
    }

    public void set_openid(String _openid) {
        this._openid = _openid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Goods> getFood() {
        return food;
    }

    public void setFood(List<Goods> food) {
        this.food = food;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "[{" +
                "_id='" + _id + '\'' +
                ", _openid='" + _openid + '\'' +
                ", date='" + date + '\'' +
                ", food='" + food + '\'' +
                ", price=" + price +
                ", state=" + state +
                "}]";
    }
}
