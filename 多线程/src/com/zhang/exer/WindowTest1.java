package com.zhang.exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。
 *
 * author PC
 * create 2021-01-14-1:39
 */
class Window1 extends Thread{
    private static int ticket = 100;   //采用继承Thread的方式，必须要加static，否则每个窗口都有100张票。

    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            ticket--;
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.start();
        w2.start();
        w3.start();
    }
}
