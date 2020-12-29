package com.zhang.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.内部的方法：hasNext() 和  next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 *
 * author PC
 * create 2020-12-29-21:32
 */
public class IteratorTest2 {
    @Test
    public void test(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add(new Date());
        coll.add(new Person("anyang",23));

        Iterator iterator = coll.iterator();

        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        //方式二：  不常用、不地道写法
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三：  常用写法
        //  ※hasNext():判断是否还有下一个元素
        while (iterator.hasNext()){

            //  ※next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add(new Date());
        coll.add(new Person("anyang",23));

        //错误方式一：
            //结果：1.集合会跳着输出；2.会抛出NoSuchElementException异常
//        Iterator iterator = coll.iterator();
//        while (iterator.next()!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二：
        //集合对象每次调用iterator()方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
        while (coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }

    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add(new Date());
        coll.add(new Person("anyang",23));

        //通过iterator对象来remove元素
        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            //iterator.next();  //会抛出NoSuchElementException异常，因为此时iterator还没有指向第一个元素，需要调用next才指向下一个元素。
            Object obj = iterator.next();
            if(obj.equals("AA")){
                iterator.remove();
            }
        }

        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
