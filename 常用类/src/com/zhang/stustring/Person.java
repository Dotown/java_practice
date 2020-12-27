package com.zhang.stustring;

/**
 * author PC
 * create 2020-12-24-1:06
 */
public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println("p1==p2 = " + (p1 == p2));//false
        System.out.println("p1.name==p2.name = " + (p1.name == p2.name));//true

    }
}


