package com.zhang.day1;

public class Demo04 {
    public static void main(String[] args) {
        //运算中，不同类型的数据先转化为同一类型，然后进行运算。
        /*
        byte,short,char<int<long<float<double
        强制转换    (类型)变量名 高->低
        自动转换    低->高

        1.布尔值不可转换
        2.不能把对象类型转为不相关的类型
        3.转换的时候可能存在内存溢出，或者精度问题。
         */
        int i = 128;
        byte b = (byte)i;
        System.out.println(i);

        //操作比较大的数的时候，注意溢出问题
        int money = 1_000_000_000;
        int years = 20;
        long total = money*years;
        long total1 = money*((long)years);
        System.out.println(total1);
    }
}
