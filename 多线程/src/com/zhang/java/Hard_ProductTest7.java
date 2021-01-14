package com.zhang.java;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产
 * 更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通
 * 知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 *
 * author PC
 * create 2021-01-15-1:25
 */
class Clerk{
    private int product = 15;


    public synchronized void produce(){
        if (product<30){
            product++;
            System.out.println(Thread.currentThread().getName()+":"+product);
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void custom(){
        if (product>0){
            product--;
            System.out.println(Thread.currentThread().getName()+":"+product);
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer implements Runnable{
    private Clerk clerk=null;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            clerk.produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Customer implements Runnable{
    private Clerk clerk=null;
    public Customer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            clerk.custom();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Hard_ProductTest7 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Customer c = new Customer(clerk);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.setName("生产者");
        t2.setName("消费者");

        t1.start();
        t2.start();
    }

}
