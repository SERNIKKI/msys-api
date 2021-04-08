package com.nikki.servlet;

import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.User;
import com.nikki.dao.MymsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@SuppressWarnings("all")
public class SetUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", Code.GET_REQUEST_ERROR);
        jsonObject.put("message",Code.GET_REQUEST_ERROR_MESSAGE);
        out.println(jsonObject);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String _openid = request.getParameter("_openid");
        String email = request.getParameter("email");
        User user = new User(_openid,uname,email);
        MymsDao mymsDao = new MymsDao();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        try {
            if(mymsDao.setUser(user)){
                jsonObject.put("code",Code.SUCCESS_CODE);
                jsonObject.put("message",Code.SUCCESS_MESSAGE);
            }else {
                jsonObject.put("code",Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
            }
        }catch (SQLException e){
            e.printStackTrace();
            jsonObject.put("code",Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
        }
        out.println(jsonObject);
        out.flush();
        out.close();
    }
}
