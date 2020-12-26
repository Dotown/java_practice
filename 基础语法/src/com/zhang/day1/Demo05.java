package com.zhang.day1;

public class Demo05 {
    //三个类型的变量:类变量、实例变量、局部变量
    //1.类变量
    static double salary = 2500;
    /* 2.实例变量：从属于对象  如果不初始化，数值类型默认值为0 0.0 false
        除了基本类型，其余的默认值都是null
     */
    public static void main(String[] args) {
        //3.局部变量必须声明和初始化值
        int i = 1;
        System.out.println(i);
        System.out.println(salary);
    }


}
