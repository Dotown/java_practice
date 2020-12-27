package com.zhang.struct.demo05;

public class Person {
    //1.静态代码块 最先执行，且只执行一次
    static {
        System.out.println("静态代码块");
    }
    //2.代码块，随着对象生成一起执行
    {
        System.out.println("代码块");
    }
    //3.构造函数，在代码块之后执行
    Person(){
        System.out.println("构造函数");
    }

    public static void main(String[] args) {
        Person p1 = new Person();
    }
}
