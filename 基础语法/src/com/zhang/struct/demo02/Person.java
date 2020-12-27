package com.zhang.struct.demo02;
//JAVA中只有单继承 没有多继承
//类与类的关系：继承、依赖、组合、聚合
//JAVA中，所有的类都默认直接或者间接继承Object类
public class Person {
    private int money;
    //Application
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void say(){
        System.out.println("Person");
    }

    //Application2
    public String name = "person";

    public Person() {
        System.out.println("person的构造函数");
    }
}
