package com.zhang.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * author PC
 * create 2021-03-23-1:50
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1、获取web.xml中配置的上下文参数context-param
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println(servletContext);
        String username = servletContext.getInitParameter("username");
        System.out.println("context-param参数username的值是:" + username);
        System.out.println("context-param参数password的值是:" + servletContext.getInitParameter("password"));

//        2、获取当前的工程路径，格式: /工程路径
        System.out.println(servletContext.getContextPath());
//        3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("工程部署的路径是:" + servletContext.getRealPath("/"));
    }
}
