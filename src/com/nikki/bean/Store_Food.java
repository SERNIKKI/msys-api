package com.nikki.bean;

public class Store_Food {
    private int M_id;
    private int S_id;
    private int F_id;
    private String F_name;
    private String F_image;
    private String F_introduction;
    private int F_price;
    private int F_num;
    private String F_unit;
    private String F_kind;
    private String S_name;
    private String F_date;

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public int getF_id() {
        return F_id;
    }

    public void setF_id(int f_id) {
        F_id = f_id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public String getF_image() {
        return F_image;
    }

    public void setF_image(String f_image) {
        F_image = f_image;
    }

    public String getF_introduction() {
        return F_introduction;
    }

    public void setF_introduction(String f_introduction) {
        F_introduction = f_introduction;
    }

    public int getF_price() {
        return F_price;
    }

    public void setF_price(int f_price) {
        F_price = f_price;
    }

    public int getF_num() {
        return F_num;
    }

    public void setF_num(int f_num) {
        F_num = f_num;
    }

    public String getF_unit() {
        return F_unit;
    }

    public void setF_unit(String f_unit) {
        F_unit = f_unit;
    }

    public String getF_kind() {
        return F_kind;
    }

    public void setF_kind(String f_kind) {
        F_kind = f_kind;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public String getF_date() {
        return F_date;
    }

    public void setF_date(String f_date) {
        F_date = f_date;
    }

    @Override
    public String toString() {
        return "Store_Food{" +
                "M_id=" + M_id +
                ", S_id=" + S_id +
                ", F_id=" + F_id +
                ", F_name='" + F_name + '\'' +
                ", F_image='" + F_image + '\'' +
                ", F_introduction='" + F_introduction + '\'' +
                ", F_price=" + F_price +
                ", F_num=" + F_num +
                ", F_unit='" + F_unit + '\'' +
                ", F_kind='" + F_kind + '\'' +
                ", S_name='" + S_name + '\'' +
                ", F_date='" + F_date + '\'' +
                '}';
    }
}
