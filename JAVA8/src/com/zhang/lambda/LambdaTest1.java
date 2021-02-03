package com.zhang.lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 * author PC
 * create 2021-02-03-22:56
 */
public class LambdaTest1 {
    @Test
    public void test(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println("我爱天安门");
            }
        };
        runnable.run();
        Runnable runnable1 = ()-> System.out.println("lambda表达式");
        runnable1.run();
    }
    @Test
    public void test1(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);
        System.out.println("***********************");
        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2)->Integer.compare(o1,o2);
        int compare2 = com2.compare(32,21);
        System.out.println(compare2);
        System.out.println("***********************");
        //方法引用
        Comparator<Integer> com3 = Integer::compareTo;
        int compare3 = com3.compare(32, 31);
        System.out.println(compare3);
    }
}
