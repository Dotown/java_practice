package com.zhang.test;

import com.zhang.bean.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * author PC
 * create 2021-03-25-1:26
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"zzzfff","psdpsd","zf@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existUsername() {
        System.out.println(userService.existUsername("admin"));
    }
}