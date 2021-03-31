package com.zhang.test;

import com.zhang.bean.User;
import com.zhang.utils.WebUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * author PC
 * create 2021-03-29-23:35
 */
public class WebUtilsTest {
    @Test
    public void webUtilsTest(){

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("id",1);
        hashMap.put("username","admin");
        hashMap.put("password","123456");
        hashMap.put("eamil","admin@11.com");

        User user = WebUtils.copyParamToBean(hashMap, new User());
        System.out.println(user);

    }
    @Test
    public void parseInt(){
        String a ="b";
        String b ="3";
        System.out.println("WebUtils.parseInt(a,5) = " + WebUtils.parseInt(a, 5));
        System.out.println("WebUtils.parseInt(b,0) = " + WebUtils.parseInt(b, 0));
    }
}