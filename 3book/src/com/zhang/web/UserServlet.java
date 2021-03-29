package com.zhang.web;

import com.zhang.bean.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * author PC
 * create 2021-03-29-22:27
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //优化一：合并 LoginServlet 和 RegistServlet 程序为 UserServlet 程序
//        String action = req.getParameter("action");
//        System.out.println(action);
////        if ("regist".equalsIgnoreCase(action)){
////            regist(req,resp);
////        }else if ("login".equalsIgnoreCase(action)){
////            login(req,resp);
////        }
//
//        //优化二：使用反射优化大量 else if 代码
//        try {
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            method.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        System.out.println("name:"+username+"password:"+password+"email:"+email+"code"+code);
        if("abcde".equalsIgnoreCase(code)){
            if (userService.existUsername(username)){
                System.out.println("用户名["+username+"]已存在");
                req.setAttribute("msg","用户名["+username+"]已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(null,"username","password","email"));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            System.out.println("输入的验证码为["+code+"]错误");
            req.setAttribute("msg","输入的验证码为["+code+"]错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(userService.login(new User(null,username,password,null))==null){
            System.out.println("用户名或密码错误");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
