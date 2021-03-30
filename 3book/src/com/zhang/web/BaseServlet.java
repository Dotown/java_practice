package com.zhang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * author PC
 * create 2021-03-29-22:51
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //优化一：合并 LoginServlet 和 RegistServlet 程序为 UserServlet 程序
        String action = req.getParameter("action");
        System.out.println(action);
//        if ("regist".equalsIgnoreCase(action)){
//            regist(req,resp);
//        }else if ("login".equalsIgnoreCase(action)){
//            login(req,resp);
//        }

        //优化二：使用反射优化大量 else if 代码
        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
