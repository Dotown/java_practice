package com.zhang.day1;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()    -->此线程执行的操作生命在run()中
 * 3.创建Thread类的子类对象
 * 4.通过此对象调用start()
 * 
 * @author Dotown
 * @create 2020-12-23-19:55
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+  " : i = " + i);
            }
        }
    }
}
public class ThreadTest1{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();//1.启动当前线程2.调用当前线程的run()
        //t1.run(); //不能通过直接调用run()方法启动线程
        //t1.start();//不可以还让已经start()的线程去执行。会报IllegalThreadStateException的错误

        //选举要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();
    }
}
