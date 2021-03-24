package com.zhang.service;

import com.zhang.bean.User;

/**
 * author PC
 * create 2021-03-25-1:01
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，则登录成功
     */
    public User login(User user);

    /**
     * 用户名是否存在
     * @param username
     * @return 如果存在则返回true，不存在则返回false
     */
    public boolean existUsername(String username);
}
