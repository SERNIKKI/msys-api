package com.nikki.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Store_Account;
import com.nikki.dao.MymsDao;
import com.nikki.utils.DBUtils;
import com.nikki.utils.RandomUtil;
import com.nikki.utils.SendQQMailUtil;

import javax.mail.MessagingException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        Connection connection = DBUtils.getConnection();
//        System.out.println(connection);
//        try {
//            connection.close();
//            System.out.println(connection);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        RandomUtil randomUtil = new RandomUtil();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(randomUtil.generateByShuffle());
//        }
//        String str = "[{\"F_price\":5,\"F_id\":4,\"F_name\":\"炸鸡腿\",\"F_image\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_unit\":\"个\",\"F_introduction\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_date\":\"2020/12/16\",\"F_kind\":\"1\"},{\"F_price\":8,\"F_id\":5,\"F_name\":\"炸鸡块\",\"F_image\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_unit\":\"份\",\"F_introduction\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_date\":\"2020/12/16\",\"F_kind\":\"1\"},{\"F_price\":10,\"F_id\":6,\"F_name\":\"鸡米花\",\"F_image\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_unit\":\"份\",\"F_introduction\":\"https://cdn.jsdelivr.net/gh/OrientalFantasy/file/logo/logo-640.jpg\",\"F_date\":\"2020/12/16\",\"F_kind\":\"1\"}]";
//        System.out.println(str.length());
//        JSONArray jsonArray = JSONArray.parseArray(str);
//        for(int i = 0; i < jsonArray.size(); i++){
//            System.out.println(jsonArray.getJSONObject(i));
//        }
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("3");
//        list.add("2");
//        list.add("1");
//        HashMap<String,Integer> map = new HashMap<>();
//        long startTime = System.currentTimeMillis();
//        for (String str : list){
//            if(map.containsKey(str)){
//                map.put(str,map.get(str) + 1);
//            }else {
//                map.put(str,1);
//            }
//        }
//        for (String str : map.keySet()){
//            System.out.println(str + " " + map.get(str));
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("The program cost :" + (endTime - startTime) + " milliseconds.");
//        MymsDao mymsDao = new MymsDao();
//        try {
//            List<Store_Account> store_accounts = mymsDao.getAllStore("1","5");
//            System.out.println(store_accounts);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        LocalDateTime now=LocalDateTime.now();
//        String a = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
//        BigInteger b = new BigInteger(a);
//        System.out.println(b.intValue());
//        System.out.println(b.longValue());

//        String result = null;
//        String url = "https://api.sernikki.cn/myms/generateOrder";// 请求接口地址
//        Map params = new HashMap();// 请求参数
//        params.put("_openid", "testtesttesttest");
//        params.put("price", "80");
//        params.put("state","0");
//        params.put("foods","[{\"F_id\":4,\"S_id\":2},{\"F_id\":5,\"S_id\":2},{\"F_id\":6,\"S_id\":2}]");
//
//        try {
//            result = HttpUtils.net(url, params, "POST");
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        MymsDao mymsDao = new MymsDao();
//        try {
//            System.out.println(mymsDao.selectAll());
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        SendQQMailUtil sendQQMailUtil = new SendQQMailUtil();
//        try {
//            sendQQMailUtil.SendMail("3cQ1HBGyDRUu6Lt9jPxzMgrJ8ak0","1823990739@qq.com");
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        RandomUtil randomUtil = new RandomUtil();
        System.out.println(randomUtil.getNum());
    }
}
