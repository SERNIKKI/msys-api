package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.Store_Food;
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
public class GetStoreFoodServlet extends HttpServlet {
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
        String S_id = request.getParameter("M_id");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Store_Food> store_foods = mymsDao.getStoreFood(S_id);
            if(store_foods.size() == 0){
                jsonObject.put("code", Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
                jsonObject.put("data","");
            }else {
                jsonObject.put("code",Code.SUCCESS_CODE);
                jsonObject.put("message",Code.SUCCESS_MESSAGE);
                JSONArray jsonArray = new JSONArray();
                for (Store_Food store_food : store_foods){
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("_id",store_food.getF_id());
                    jsonObject1.put("goods_img",store_food.getF_image());
                    jsonObject1.put("goods_info",store_food.getF_introduction());
                    jsonObject1.put("goods_name",store_food.getF_name());
                    jsonObject1.put("goods_price",store_food.getF_price());
                    jsonObject1.put("goods_time",store_food.getF_date());
                    jsonObject1.put("goods_kind",store_food.getF_kind());
                    jsonObject1.put("goods_unit",store_food.getF_unit());
                    jsonObject1.put("_openid",store_food.getS_id());
                    jsonArray.add(jsonObject1);
                }
                jsonObject.put("data",jsonArray);
            }
            out.println(jsonObject);
        } catch (SQLException e) {
            jsonObject.put("code",Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
            jsonObject.put("data","");
            out.println(jsonObject);
        }
        out.flush();
        out.close();
    }
}
