package com.zhang.stustring;

import org.junit.Test;

/**
 * 面试题：String s3 = new String("java"); 方式创建对象，在内存中创建了几个对象？
 * 两个：一个是堆空间中的new结构，另一个是char[]对应的常量池中的数据:"abc"
 *
 *
 *String:字符串，使用一对""来表示
 * 1.String声明为final，不可被继承
 * 2.String实现了Serializable接口：表示字符串时支持序列化的。
 *         实现了Comparable接口：表示String可以比较大小
 * 3.String内部定义了final char[] value用于存储字符串数据
 * 4.代表不可变的字符序列。简称：不可变性
 *      重新修改，字符串连接，字符串replace均要重新指定内存区域。
 * 5.通过字面量的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中。
 * 6.字符串常量池中是不会存储相同内容的字符串的。
 *
 * author PC
 * create 2020-12-23-23:59
 */
public class StringTest0 {
    @Test
    public void StringDemo(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   //这里比较的是引用的地址
        String s3 = "abc";
        s3+="def";
        System.out.println("s3 = " + s3);
        System.out.println("s2 = " + s2);

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);

    }

    /*
    实例化方式：
    1.通过字面量定义
    2.通过new+构造器的方式
     */

    @Test
    public void test2(){

        //此时的s1和s2的数据java生命在方法区中的字符串常量池中。
        String s1 = "java";
        String s2 = "java";

        //此时的s3和s4保存的地址值，是数据在堆空间开辟空间以后对应的地址
        String s3 = new String("java");
        String s4 = new String("java");

        System.out.println(s1==s2);//true
        System.out.println(s3==s4);//false
        System.out.println(s1 == s3);//false
    }
}
