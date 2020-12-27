package com.zhang.struct;

public class Demo02 {
    public static void main(String[] args) {


    }
    //和对象一起产生
    public void a(){
        b(); //可以调用静态方法
    }

    //静态方法，跟类一起产生
    public static void b(){
        //a();  不可以调用非静态方法

    }
}
