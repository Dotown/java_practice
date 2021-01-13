package com.zhang.exer;

/**
 * 例子：创建三个窗口卖票，总票数为100张.使用实现Runnable接口的方式
 * 存在线程的安全问题，待解决。
 *
 * author PC
 * create 2021-01-14-1:45
 */
class Window2 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (ticket>0){
            System.out.println(Thread.currentThread().getName()+":"+ticket);
            ticket--;
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();

        Thread t1 = new Thread(window2);
        Thread t2 = new Thread(window2);
        Thread t3 = new Thread(window2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
