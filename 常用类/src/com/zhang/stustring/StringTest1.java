package com.zhang.stustring;

import org.junit.Test;

/**
 * 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
 * 只要有一个是变量，结果就在堆中
 * intern方法返回的结果军保存在常量池中
 *
 * @author Dotown
 * @create 2020-12-24-10:57
 */
public class StringTest1 {
    @Test
    public void test3(){
        String s1 = "java";
        String s2 = "hadoop";

        String s3 ="javahadoop";
        String s4 = "java" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = s1 + s2;

        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//flase
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false

        String s7 = s5.intern();
        System.out.println(s3==s7);//true

        final String s8 = "java";
        String s9 = s8 + "hadoop";
        System.out.println("s9 == s3 " + (s9 == s3)); //true
    }

}
