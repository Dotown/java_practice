package com.zhang.struct;

import www.zhang.struct.demo04.Person;
import www.zhang.struct.demo04.Student;
import www.zhang.struct.demo04.Teacher;

public class AppDemo04 {
    public static void main(String[] args) {
        Object o1 = new Student();
        System.out.println(o1 instanceof Object);//true
        System.out.println(o1 instanceof Person);//true
        System.out.println(o1 instanceof Student);//true
        System.out.println(o1 instanceof Teacher);//false
        System.out.println(o1 instanceof String);//false

        Person p1 = new Student();
        System.out.println(p1 instanceof Object);//true
        System.out.println(p1 instanceof Person);//true
        System.out.println(p1 instanceof Student);//true
        System.out.println(p1 instanceof Teacher);//false
        //System.out.println(p1 instanceof String);//编译报错

        Student s1 = new Student();
        System.out.println(s1 instanceof Object);//true
        System.out.println(s1 instanceof Person);//true
        System.out.println(s1 instanceof Student);//true
        //System.out.println(s1 instanceof Teacher);//编译报错
        //System.out.println(s1 instanceof String);//编译报错

        //高             低
        Person p2 = new Student();
        ((Student)p2).run();  //父类转换为父类需要强制转换  高转低


    }

}
