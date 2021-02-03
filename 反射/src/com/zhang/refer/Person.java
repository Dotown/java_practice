package com.zhang.refer;
/**
 * author PC
 * create 2021-02-03-16:31
 */
@MyAnnotation("hello")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String display(String interests,int age) throws NullPointerException,ClassCastException{
        return interests + age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
