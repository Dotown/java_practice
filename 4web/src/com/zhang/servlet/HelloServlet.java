package com.zhang.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 直接实现Servlet接口
 *
 * author PC
 * create 2021-03-23-0:31
 */
public class HelloServlet implements Servlet {
    public HelloServlet(){
        System.out.println("1 构造器方法");
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

//        1、可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloServlet程序的别名是:" + servletConfig.getServletName());
//        2、获取初始化参数init-param
        System.out.println("初始化参数username的值是;" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是;" + servletConfig.getInitParameter("url"));
//        3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
    service方法专门用来处理请求和响应的
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3 service === Hello Servlet 被访问了");
        HttpServletRequest httpServletRequest =(HttpServletRequest)servletRequest;
        String method = httpServletRequest.getMethod();
        if("GET".equals(method)){
            System.out.println("GET方法");
        }else if("POST".equals(method)){
            System.out.println("POST方法");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy销毁方法");
    }
}
