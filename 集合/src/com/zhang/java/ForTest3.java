package com.zhang.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合、数组
 *  遍历集合的底层调用Iterator完成操作。
 *
 * author PC
 * create 2020-12-29-23:13
 */
public class ForTest3 {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add("DD");
        coll.add(new Person("anyang",23));

        //for(集合元素的类型 局部变量 : 集合对象)
        //设置断点查看 内部仍然调用了迭代器。
        for(Object obj : coll){
            System.out.println("obj = " + obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //for(数组元素的类型 局部变量 : 数组对象)
        for(int i : arr){
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3(){
        String[] arr = new String[]{"MM","MM","MM"};

        //方式一：普通for赋值
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = "GG";    //GG GG GG
//        }

        //方式二：增强for循环
        for(String s : arr){
            s = "GG";   //MM MM MM  因为此时是将arr数组中的值取出来赋值给局部变量s，原本的数组并没有改变。
        }

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
