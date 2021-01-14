package com.zhang.exer;

/**
 * 银行有一个账户有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * 分析：
 * 是否是多线程问题：是
 * 是否有共享数据：是
 * 是否有线程安全问题：有
 * 需要考虑如何解决线程安全问题？同步机制：有三种方式
 *
 * author PC
 * create 2021-01-14-23:11
 */
class Account{
    private double balance;
    public Account(double balance){
        this.balance = balance;
    }
    public synchronized void deposit(double amt){   //采用同步方法
    //public void deposit(double amt){
        if (amt>0){
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：存钱成功。余额："+balance);
        }
    }
}
class Customer extends Thread{
    private Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000L);
        }
    }
}
public class AccountTest3 {
    public static void main(String[] args) {
        Account account = new Account(3000L);

        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

//        c1.setName("客户1");
//        c2.setName("客户2");

        c1.start();
        c2.start();
    }
}
