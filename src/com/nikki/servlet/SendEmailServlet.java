package com.nikki.servlet;

import com.alibaba.fastjson.JSONObject;
import com.nikki.bean.Code;
import com.nikki.bean.User;
import com.nikki.dao.MymsDao;
import com.nikki.utils.SendQQMailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@SuppressWarnings("all")
public class SendEmailServlet extends HttpServlet {
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
        //订单id
        String _id = request.getParameter("_id");
        //用户id
        String _openid = request.getParameter("_openid");
        MymsDao mymsDao = new MymsDao();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        JSONObject jsonObject = new JSONObject();
        //查询订单状态
        int state = -1;
        try {
            state = mymsDao.selectState(_id,_openid);
            if(state != 1){
                User user = mymsDao.getUser(_openid);
                if(user.getEmail()!=null){
                    SendQQMailUtil sendQQMailUtil = new SendQQMailUtil();
                    sendQQMailUtil.SendMail(_id,user.getEmail());
                    jsonObject.put("code",Code.SUCCESS_MESSAGE);
                    jsonObject.put("message",Code.SUCCESS_MESSAGE);
                }else {
                    jsonObject.put("code",Code.ERROR_CODE);
                    jsonObject.put("message",Code.ERROR_MESSAGE);
                }
            }else {
                jsonObject.put("code",Code.ERROR_CODE);
                jsonObject.put("message",Code.ERROR_MESSAGE);
            }
        } catch (SQLException | MessagingException throwables) {
            jsonObject.put("code",Code.OTHER_ERROR_CODE);
            jsonObject.put("message",Code.OTHER_ERROR_MESSAGE);
        }
        out.println(jsonObject);
        out.flush();
        out.close();
    }
}
