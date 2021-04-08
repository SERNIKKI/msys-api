package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.Goods;
import com.nikki.bean.Orders;
import com.nikki.dao.MymsDao;
import com.nikki.utils.RandomUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class GenerateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RandomUtil randomUtil = new RandomUtil();
        MymsDao mymsDao = new MymsDao();
        Orders orders = new Orders();
        String _id = randomUtil.generateByShuffle();
        orders.set_id(_id);
        SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        orders.setDate(sm.format(date));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject1 = new JSONObject();
        String _openid = request.getParameter("_openid");
        String foods = request.getParameter("foods");
        String price = request.getParameter("price");
        String state = request.getParameter("state");
        orders.set_openid(_openid);
        orders.setPrice(Integer.parseInt(price));
        orders.setState(Integer.parseInt(state));
        JSONArray jsonArray = JSONArray.parseArray(foods);
        //获取foods中相同菜品的数目
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < jsonArray.size(); i++){
            String str = jsonArray.getJSONObject(i).getString("F_id");
            if(map.containsKey(str)){
                map.put(str,map.get(str) + 1);
            }else {
                map.put(str,1);
            }
        }//end
        List<Goods> goods1 = new ArrayList<>();
        for (String str : map.keySet()){
            for (int i = 0; i < jsonArray.size(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if(str.equals(jsonObject.getString("F_id"))) {
                    LocalDateTime now = LocalDateTime.now();
                    String goods_time = now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
                    BigInteger bigInteger = new BigInteger(goods_time);
                    Goods goods = new Goods();
                    goods.setF_id(Integer.parseInt(jsonObject.getString("F_id")));
                    goods.setGoods_time(bigInteger.longValue());
                    goods.setS_id(Integer.parseInt(jsonObject.getString("S_id")));
                    goods.set_openid(_openid);
                    goods.setGoods_num(map.get(str));
                    goods.set_id(_id);
                    try {
                        boolean bool = mymsDao.insertGoods(goods);
                        if(!bool){
                            jsonObject1.put("code", Code.ERROR_CODE);
                            jsonObject1.put("message", Code.ERROR_MESSAGE);
                            jsonObject1.put("order_id","");
                            out.println(jsonObject1);
                            out.flush();
                            out.close();
                            return;
                        }
                        goods1.add(goods);
                        break;
                    } catch (SQLException e) {
                        jsonObject1.put("code", Code.OTHER_ERROR_CODE);
                        jsonObject1.put("message", Code.OTHER_ERROR_MESSAGE);
                        jsonObject1.put("order_id","");
                        out.println(jsonObject1);
                        out.flush();
                        out.close();
                        return;
                    }
                }
            }
        }
        orders.setFood(goods1);
        try {
            boolean bool = mymsDao.generateOrder(orders);
            if(!bool){
                jsonObject1.put("code", Code.ERROR_CODE);
                jsonObject1.put("message", Code.ERROR_MESSAGE);
                jsonObject1.put("order_id","");
                out.println(jsonObject1);
                out.flush();
                out.close();
                return;
            }
            jsonObject1.put("code", Code.SUCCESS_CODE);
            jsonObject1.put("message", Code.SUCCESS_MESSAGE);
            jsonObject1.put("order_id",_id);
            out.println(jsonObject1);
            out.flush();
            out.close();
        } catch (SQLException e) {
            jsonObject1.put("code", Code.OTHER_ERROR_CODE);
            jsonObject1.put("message", Code.OTHER_ERROR_CODE);
            jsonObject1.put("order_id","");
            out.println(jsonObject1);
            out.flush();
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",Code.POST_REQUEST_ERROR);
        jsonObject.put("message",Code.POST_REQUEST_ERROR_MESSAGE);
        jsonObject.put("order_id","");
        out.println(jsonObject);
        out.flush();
        out.close();
    }
}
