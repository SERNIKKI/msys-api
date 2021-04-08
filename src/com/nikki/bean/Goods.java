package com.nikki.bean;

public class Goods {
    private int id;
    private String _id;
    private String _openid;
    private int F_id;
    private int goods_num;
    private int S_id;
    private Long goods_time;
    private String goods_image;
    private String goods_info;
    private String goods_name;
    private int goods_price;
    private String S_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getF_id() {
        return F_id;
    }

    public void setF_id(int f_id) {
        F_id = f_id;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public Long getGoods_time() {
        return goods_time;
    }

    public void setGoods_time(Long goods_time) {
        this.goods_time = goods_time;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(int goods_price) {
        this.goods_price = goods_price;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }


    @Override
    public String toString() {
        return "[{" +
                "id=" + id +
                ", _id='" + _id + '\'' +
                ", _openid='" + _openid + '\'' +
                ", F_id=" + F_id +
                ", goods_num=" + goods_num +
                ", S_id=" + S_id +
                ", goods_time=" + goods_time +
                ", goods_image='" + goods_image + '\'' +
                ", goods_info='" + goods_info + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", S_name='" + S_name + '\'' +
                "}]";
    }
}
