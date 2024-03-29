package com.zhang.web;

import com.zhang.bean.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dotown
 * @create 2021-03-25-10:19
 */
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
}
