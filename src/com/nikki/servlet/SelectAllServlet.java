package com.nikki.servlet;

import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.dao.MymsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings("all")
public class SelectAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", Code.GET_REQUEST_ERROR);
        jsonObject.put("message",Code.GET_REQUEST_ERROR_MESSAGE);
        jsonObject.put("data","");
        out.println(jsonObject);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        MymsDao mymsDao = new MymsDao();
        try {
            int rows = mymsDao.selectAll();
            jsonObject.put("code", Code.SUCCESS_CODE);
            jsonObject.put("message",Code.SUCCESS_MESSAGE);
            jsonObject.put("data",rows);
        } catch (SQLException throwables) {
            jsonObject.put("code", Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
            jsonObject.put("data","");
        }
        out.println(jsonObject);
        out.flush();
        out.close();
    }
}
