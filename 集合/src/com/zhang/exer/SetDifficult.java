package com.zhang.exer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;

/**
 * author PC
 * create 2020-12-31-0:13
 */
public class SetDifficult {
    @Test
    public void test(){
        HashSet set = new HashSet();
        Human p1 = new Human(1001,"AA");
        Human p2 = new Human(1002,"BB");
        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);     //这里remove失败了，因为p1的值变了，位置却没有变。  因此找不到添加时p1的位置
        System.out.println(set);    //[Human{id=1002, name='BB'}, Human{id=1001, name='CC'}]
        set.add(new Human(1001,"CC"));
        System.out.println(set);    //[Human{id=1002, name='BB'}, Human{id=1001, name='CC'}, Human{id=1001, name='CC'}]
        set.add(new Human(1001,"AA"));
        System.out.println(set);    //[Human{id=1002, name='BB'}, Human{id=1001, name='CC'}, Human{id=1001, name='CC'}, Human{id=1001, name='AA'}]
    }
}
class Human{
    int id;
    String name;

    public Human() {
    }

    public Human(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id && Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
