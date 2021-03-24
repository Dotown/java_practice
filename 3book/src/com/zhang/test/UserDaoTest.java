package com.zhang.test;

import com.zhang.bean.User;
import com.zhang.dao.UserDao;
import com.zhang.dao.impl.UserDaoImpl;
import org.junit.Test;

/**
 * @author Dotown
 * @create 2021-03-24-21:00
 */
public class UserDaoTest {

    UserDao userdao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if(userdao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在");
        }

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userdao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或者密码错误，登录失败");
        }else{
            System.out.println("查询成功");
        }

    }

    @Test
    public void saveUser() {
        System.out.println(userdao.saveUser(new User(null,"zzz168","123456","zzz@qq.com")));
    }
}