package com.zhang.stustring;

import org.junit.Test;

/**
 * StringBuffer和StringBuilder的使用
 *
 * @author Dotown
 * @create 2020-12-25-20:10
 */
public class StringBufferBuilderTest5 {
    /*
    String：不可变的字符序列
    StringBuffer：可变的字符序列，线程安全的，效率低
    StringBuilder：可变的字符序列，线程不安全的，效率高；jdk5.0新增的
    底层均使用char[]存储

    源码分析：
    StringBuffer sb1 = new StringBuffer();//value = new char[16]; 创建了一个16字符大小的char数组
    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length + 16] 额外空出16个字符大小的char数组
    Q1.s1.length()是实际长度   16是capacity
    Q2.如果添加的数据底层数组盛不下了，需要扩容底层的数组
       默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。

        开发中建议大家使用：StringBuffer(int  capacity)或者StringBuilder(int  capacity)
     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        System.out.println("sb1.length() = " + sb1.length());
    }


    /*
    StringBuilder和StringBuffer常用方法：
StringBuffer append(xxx)：提供了很多的append()方法， 用于进行字符串拼接
StringBuffer delete(int start,int end)：删除指定位置的内容
StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
StringBuffer insert(int offset, xxx)：在指定位置插入xxx
StringBuffer reverse() ：把当前字符序列逆转
public int indexOf(String str)
public String substring(int start,int end)返回一个左闭右开的子字符串，此时方法的调用者没有变化
public int length()
public char charAt(int n )
public void setCharAt(int n ,char ch)

    增：append  支持方法链操作
    删：delete
    改：setCharAt replace
    查：charAt
    插：insert
    长度：length
    遍历：for()+charAt() /toString()
     */

}
