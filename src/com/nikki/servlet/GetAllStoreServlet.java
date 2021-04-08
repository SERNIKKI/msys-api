package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.Store_Account;
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
public class GetAllStoreServlet extends HttpServlet {
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
        String page = request.getParameter("page");
        String limit = request.getParameter("num");
        JSONObject jsonObject = new JSONObject();
        try {
            List<Store_Account> store_accounts = mymsDao.getAllStore(page,limit);
            if(store_accounts.size() == 0){
                jsonObject.put("code",Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
                jsonObject.put("data","");
            }else {
                jsonObject.put("code",Code.SUCCESS_CODE);
                jsonObject.put("message",Code.SUCCESS_MESSAGE);
                JSONArray jsonArray = new JSONArray();
                for (Store_Account store_account : store_accounts) {
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("M_content", store_account.getS_content());
                    jsonObject1.put("M_telephone", store_account.getS_telephone());
                    jsonObject1.put("M_image", store_account.getS_image());
                    jsonObject1.put("M_name", store_account.getS_name());
                    jsonObject1.put("_id", store_account.getS_id());
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
