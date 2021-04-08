package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.Goods;
import com.nikki.bean.Orders;
import com.nikki.dao.MymsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")
public class GetOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",Code.GET_REQUEST_ERROR);
        jsonObject.put("message",Code.GET_REQUEST_ERROR_MESSAGE);
        jsonObject.put("data","");
        out.println(jsonObject);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MymsDao mymsDao = new MymsDao();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String _openid = request.getParameter("_openid");
        String state = request.getParameter("state");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Orders> orders = mymsDao.getOrders(_openid,state);
            if(orders.size() == 0){
                jsonObject.put("code", Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
                jsonObject.put("data","");
                out.println(jsonObject);
                out.flush();
                out.close();
                return;
            }else {
                jsonObject.put("code",Code.SUCCESS_CODE);
                jsonObject.put("message",Code.SUCCESS_MESSAGE);
                JSONArray jsonArray = new JSONArray();
                for (Orders orders1 : orders) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("_id",orders1.get_id());
                    jsonObject1.put("_openid",orders1.get_openid());
                    jsonObject1.put("date",orders1.getDate());
                    jsonObject1.put("price",orders1.getPrice());
                    jsonObject1.put("state",orders1.getState());
                    System.out.println("_id :" + orders1.get_id());
                    JSONArray jsonArray1 = new JSONArray();
                    List<Goods> goods = mymsDao.getGoods(orders1.get_id());
                    for (Goods goods1 : goods){
                        System.out.println(goods1);
                        JSONObject jsonObject2 = new JSONObject();
                        jsonObject2.put("_id",goods1.getF_id());
                        jsonObject2.put("goods_img",goods1.getGoods_image());
                        jsonObject2.put("goods_info",goods1.getGoods_info());
                        jsonObject2.put("goods_name",goods1.getGoods_name());
                        jsonObject2.put("goods_price",goods1.getGoods_price());
                        jsonObject2.put("goods_time",goods1.getGoods_time());
                        jsonObject2.put("goods_user",goods1.getS_name());
                        jsonObject2.put("_openid",goods1.get_openid());
                        jsonArray1.add(jsonObject2);
                    }
                    jsonObject1.put("foods",jsonArray1);
                    jsonArray.add(jsonObject1);
                }
                jsonObject.put("data",jsonArray);
            }
            out.println(jsonObject);
        } catch (SQLException e) {
            e.printStackTrace();
            jsonObject.put("code",Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
            jsonObject.put("data","");
            out.println(jsonObject);
        }
        out.flush();
        out.close();
    }
}
