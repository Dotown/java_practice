package com.zhang.struct.demo02;

public class Teacher extends Person{
    public String name = "teacher";
    public void print(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);//super.name为父类的name
    }

    //默认调用了父类的无参构造
    //调用父类的构造器时，应把父类的构造函数放在第一行
    public Teacher() {
        super();
        System.out.println("teacher的构造函数");
    }
}
