package com.nikki.servlet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Store_Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class wyy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RhesisDao rhesisDao = new RhesisDao();
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        PrintWriter out = response.getWriter();
//        Store_Account storeaccount = rhesisDao.selectAll();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code", storeaccount.getCode());
//        jsonObject.put("message", storeaccount.getMessing());
//        JSONArray array = new JSONArray();
//        JSONObject jsonObject1 = new JSONObject();
//        jsonObject1.put("sentence", storeaccount.getRhesis_sentence());
//        jsonObject1.put("book", storeaccount.getRhesis_book());
//        jsonObject1.put("writer", storeaccount.getRhesis_writer());
//        array.add(jsonObject1);
//        jsonObject.put("data",array);
//        out.println(jsonObject);
//        out.flush();
//        out.close();
//        rhesisDao.close();
    }
}
