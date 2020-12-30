package com.zhang.java1;

import java.util.Objects;

/**
 * @author Dotown
 * @create 2020-12-30-16:29
 */
public class User implements Comparable{
    private String name;
    private int age;

    //自然排序
    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User u = (User) o;
            return this.name.compareTo(u.name);
        }else{
            throw new RuntimeException("对象类型不一致");
        }
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("调用equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        System.out.println("调用hashCode");
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
