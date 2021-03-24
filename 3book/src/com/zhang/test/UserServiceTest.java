package com.zhang.test;

import com.zhang.bean.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * author PC
 * create 2021-03-25-1:26
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();
    @Test
    public void registUser(User user) {
        userService.registUser(new User(null,"zzzfff","psdpsd","zf@qq.com"));
    }

    @Test
    public void login(User user) {
        userService.login()
    }

    @Test
    public void existUsername(String username) {
    }
}