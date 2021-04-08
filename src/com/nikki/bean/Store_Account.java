package com.nikki.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Store_Account {
    private int S_id;
    private String S_name;
    private int S_menu;
    private String S_location;
    private String S_telephone;
    private String S_email;
    private String S_time;
    private String S_image;
    private String S_safe_image;
    private int type;
    private String S_content;
    private String S_user;
    private String S_user_telephone;

    public int getS_id() {
        return S_id;
    }

    public void setS_id(int s_id) {
        S_id = s_id;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public int getS_menu() {
        return S_menu;
    }

    public void setS_menu(int s_menu) {
        S_menu = s_menu;
    }

    public String getS_location() {
        return S_location;
    }

    public void setS_location(String s_location) {
        S_location = s_location;
    }

    public String getS_telephone() {
        return S_telephone;
    }

    public void setS_telephone(String s_telephone) {
        S_telephone = s_telephone;
    }

    public String getS_email() {
        return S_email;
    }

    public void setS_email(String s_email) {
        S_email = s_email;
    }

    public String getS_time() {
        return S_time;
    }

    public void setS_time(String s_time) {
        S_time = s_time;
    }

    public String getS_image() {
        return S_image;
    }

    public void setS_image(String s_image) {
        S_image = s_image;
    }

    public String getS_safe_image() {
        return S_safe_image;
    }

    public void setS_safe_image(String s_safe_image) {
        S_safe_image = s_safe_image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getS_content() {
        return S_content;
    }

    public void setS_content(String s_content) {
        S_content = s_content;
    }

    public String getS_user() {
        return S_user;
    }

    public void setS_user(String s_user) {
        S_user = s_user;
    }

    public String getS_user_telephone() {
        return S_user_telephone;
    }

    public void setS_user_telephone(String s_user_telephone) {
        S_user_telephone = s_user_telephone;
    }

    @Override
    public String toString() {
        return "Store_Account{" +
                "S_id=" + S_id +
                ", S_name='" + S_name + '\'' +
                ", S_menu=" + S_menu +
                ", S_location='" + S_location + '\'' +
                ", S_telephone='" + S_telephone + '\'' +
                ", S_email='" + S_email + '\'' +
                ", S_time='" + S_time + '\'' +
                ", S_image='" + S_image + '\'' +
                ", S_safe_image='" + S_safe_image + '\'' +
                ", type=" + type +
                ", S_content='" + S_content + '\'' +
                ", S_user='" + S_user + '\'' +
                ", S_user_telephone='" + S_user_telephone + '\'' +
                '}';
    }
//    public void setInputdata(){
//        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date=new Date();
//        this.inputtime = sm.format(date);
//    }
}
