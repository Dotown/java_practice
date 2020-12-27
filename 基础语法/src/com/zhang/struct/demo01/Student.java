package com.zhang.struct.demo01;
/*
构造器的名字和类名一致，且没有返回值
 */
public class Student {
    String name;
    int age;

    public void playGame() {
        System.out.println(this.name + this.age);
    }

    //使用new关键字，本质就是在调用构造器
    //一旦定义了有参构造，无参构造就要显式的体现出来

    //alt + insert


    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

}
