package com.zhang.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 继承HttpServlet类
 * author PC
 * create 2021-03-23-0:57
 */
public class HelloServlet2 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("重写了init初始化方法,做了一些工作");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doGet方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);
        System.out.println("初始化参数username的值是;" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是;" + servletConfig.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
