package com.zhang.service.impl;

import com.zhang.bean.User;
import com.zhang.dao.UserDao;
import com.zhang.dao.impl.UserDaoImpl;
import com.zhang.service.UserService;

/**
 * author PC
 * create 2021-03-25-1:17
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;
        }
        return true;
    }
}
