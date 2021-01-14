package com.zhang.solution;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * author PC
 * create 2021-01-15-0:00
 */
class Bank{
    private static Bank bank;
    private Bank(){
    }
    public static Bank getBank(){
        //方式一：效率稍差
//        synchronized (BankTest5.class){
//            if (bank==null){
//                bank = new Bank();
//            }
//        }
        //方式二：效率更高
        if (bank==null){    //如果不为空,没必要进锁
            synchronized (BankTest5.class){
                if (bank==null){
                    bank = new Bank();
                }
            }
        }
        return bank;
    }
}
public class BankTest5 {

}
