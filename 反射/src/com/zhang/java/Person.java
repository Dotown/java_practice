package com.zhang.java;

/**
 * 私有成员：name
 * 私有方法：Person(String name)、showNation(String nation)
 *
 * author PC
 * create 2021-01-29-20:21
 */
public class Person {
    private String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
        System.out.println("person的构造器");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {   //私有
        this.name = name;
    }

    public void show(){
        System.out.println("你好，我是一个人");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

}
