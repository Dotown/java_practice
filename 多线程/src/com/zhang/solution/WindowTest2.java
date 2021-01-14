package com.zhang.solution;

/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 * @author Dotown
 * @create 2021-01-14-11:12
 */
class Window2 extends Thread{
    private static int ticket = 100;
//    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (Window2.class) {  //Class clazz = Window2.class,  Window2.class只会加载一次
          //synchronized (this) {               //错误的方式：this代表着t1,t2,t3三个对象
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName()+":"+ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
