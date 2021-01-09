package com.zhang.exer;

/**
 * 创建两个分线程，其中一个遍历100以内的偶数，另一个线程遍历100以内的奇数
 * @author Dotown
 * @create 2020-12-23-20:28
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(){   //Thread的匿名子类
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println("i = " + i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    if(i%2!=0){
                        System.out.println("i = " + i);
                    }
                }
            }
        }.start();
    }
}
