package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.Store_Account;
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
public class GetStoreSServlet extends HttpServlet {
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
        String S_type = request.getParameter("M_type");
        System.out.println("M_type = " + S_type);
        JSONObject jsonObject = new JSONObject();
        try {
            List<Store_Account> store_accounts = mymsDao.getStores(S_type);
            System.out.println(store_accounts);
            if(store_accounts.size() == 0){
                jsonObject.put("code", Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
                jsonObject.put("data","");
                out.println(jsonObject);
                out.flush();
                out.close();
            }else {
                jsonObject.put("code",Code.SUCCESS_CODE);
                jsonObject.put("message",Code.SUCCESS_MESSAGE);
                JSONArray jsonArray = new JSONArray();
                for (Store_Account store_account : store_accounts){
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("S_id",store_account.getS_id());
                    jsonObject1.put("S_name",store_account.getS_name());
                    jsonObject1.put("S_location",store_account.getS_location());
                    jsonObject1.put("S_content",store_account.getS_content());
                    jsonObject1.put("S_telephone",store_account.getS_telephone());
                    jsonObject1.put("S_email",store_account.getS_email());
                    jsonObject1.put("S_time",store_account.getS_time());
                    jsonObject1.put("S_image",store_account.getS_image());
                    jsonObject1.put("S_type",store_account.getType());
                    System.out.println("S_id = " + store_account.getS_id());
                    jsonArray.add(jsonObject1);
                }
                jsonObject.put("data",jsonArray);
                out.println(jsonObject);
                out.flush();
                out.close();
            }
        } catch (SQLException e) {
            jsonObject.put("code", Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
            jsonObject.put("data","");
            out.println(jsonObject);
            out.flush();
            out.close();
        }
    }
}
