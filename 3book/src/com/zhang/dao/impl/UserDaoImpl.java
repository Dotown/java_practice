package com.zhang.dao.impl;

import com.zhang.bean.User;
import com.zhang.dao.UserDao;

/**
 * @author Dotown
 * @create 2021-03-24-20:36
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "SELECT id,username,PASSWORD,email FROM t_user WHERE username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id,username,PASSWORD,email FROM t_user WHERE username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO t_user(`username`,`password`,`email`) VALUES(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
