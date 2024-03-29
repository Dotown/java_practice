package com.zhang.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * author PC
 * create 2021-03-29-23:13
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            System.out.println("注入之前：" + bean);
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String object,int defaultValue){
        try {
            int i = Integer.parseInt(object);
            return i;
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
