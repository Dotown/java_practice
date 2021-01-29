package com.zhang.java;

/**
 * 演示线程的死锁问题
 * 1.死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 * 2.说明：
 *   1）出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续
 *   2）我们使用同步时，要避免出现死锁。
 *
 * author PC
 * create 2021-01-15-0:14
 */
public class LockTest4 {
    public static void main(String[] args) {
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized (str1){
                    str1.append("A1");
                    str2.append("A2");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (str2){
                        str1.append("B1");
                        str2.append("B2");
                        System.out.println("str1:"+str1+"----str2:"+str2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (str2){
                    str1.append("C1");
                    str2.append("C2");

                    try {
                        Thread.sleep(100);  //由于Runnable接口中没有sleep方法,只好通过Thread调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (str1){
                        str1.append("D1");
                        str2.append("D2");
                        System.out.println("str1:"+str1+"----str2:"+str2);
                    }
                }
            }
        }).start();
    }
}
