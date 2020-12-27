package com.zhang.struct;

import www.zhang.struct.demo03.FatherB;
import www.zhang.struct.demo03.SonA;

public class AppDemo03 {
    public static void main(String[] args) {
        //A是子类
//        SonA a = new SonA();
//        a.test();//A-test
//        //父类的引用指向了子类
//        B b = new SonA();
//        b.test();//B-test

        SonA a = new SonA();
        a.test();//B-test
        FatherB b = new SonA();
        b.test();//B-test   子类重写了父类的方法，执行子类的方法
        Object c = new SonA();

        //b.eat();  //对象能够执行哪些方法，主要看对象左边的类型，和右边关系不大
        //不能调用子类独有的方法

        //对象能够执行
    }
}
