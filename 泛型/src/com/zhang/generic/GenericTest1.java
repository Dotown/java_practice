package com.zhang.generic;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 *  1.jdk 5.0新增的特性
 *
 *  2.在集合中使用泛型：
 *   总结：
 *   ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *   ② 在实例化集合类时，可以指明具体的泛型类型
 *   ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型。
 *     比如：add(E e)  --->实例化以后：add(Integer e)
 *   ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *   ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 *  3.如何自定义泛型结构：泛型类、泛型接口；泛型方法。见 GenericTest2.java
 *
 * author PC
 * create 2021-01-08-0:43
 */
public class GenericTest1 {

    //在集合中使用泛型之前的情况：
    @Test
    public void test(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        //问题一：类型不安全
//        list.add("Tom");

        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        //编译时，就会进行类型检查，保证数据的安全
//        list.add("Tom");

        //遍历方式一
        for(Integer a : list){
            //避免了强转操作
            int stuScore = a;
            System.out.println(stuScore);
        }
        //遍历方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test2(){
//        HashMap<String, Integer> map = new HashMap<>();

        //jdk7新特性：类型推断  ****
        Map<String,Integer> map = new HashMap<>();

        map.put("AA",123);
        map.put("BB",456);
        map.put("CC",789);
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> e = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = e.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+"--->"+next.getValue());
        }


    }


}
