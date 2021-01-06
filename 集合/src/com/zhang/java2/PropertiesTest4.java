package com.zhang.java2;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Dotown
 * @create 2021-01-06-12:55
 */
public class PropertiesTest4 {
    @Test
    public void test(){

        FileInputStream fls = null;
        try {
            Properties pro = new Properties();
            fls = new FileInputStream("D:\\User_cs\\JAVA\\JavaSE\\集合\\src\\com\\zhang\\java2\\jdbc.properties");
            pro.load(fls);
            String name = pro.getProperty("name");
            String password = pro.getProperty("password");
            System.out.println("name="+name+", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fls!=null) {
                try {
                    fls.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
