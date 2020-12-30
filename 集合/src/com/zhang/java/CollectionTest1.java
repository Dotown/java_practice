package com.zhang.java;
import org.junit.Test;

import java.util.*;

/**
 *
 * 一、集合框架的概述
 *  1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 *  说明:此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储(.txt,.jpg,.avi,数据库中的数据)
 *
 *  2.1数组在存储多个数据方面的特点:
 *      >一旦初始化以后，其长度就确定了。
 *      >数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *      比如: String[] arr;int[] arr1;object[] arr2;
 *  2.2数组在存储多个数据方面的缺点:
 *      >一旦初始化以后，其长度就不可修改。
 *      >数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      >获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用。
 *      >数组存储数据的特点:有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 *      |----Collection接口：单列集合，用来存储一个一个的对象
 *          |----List接口：存储有序的、可重复的数据  -->"动态"数组
 *              |----ArrayList、LinkedList、Vector
 *
 *          |----Set接口：存储无序的、不可重复的数据 -->高中讲的"集合"
 *              |----HashSet、LinkedHashSet、TreeSet
 *          |----Map接口：双列集合，用来存储一对(key - value)一对的数据  --> 高中函数：y = f(x)
 *              |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection接口中方法的使用
 *      向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * author PC
 * create 2020-12-28-23:05
 */
public class CollectionTest1 {
    @Test
    public void test1(){
        //add addAll clear size isEmpty
        Collection coll = new ArrayList();
        coll.add("AA"); //add方法
        coll.add(123);
        coll.add(new Date());
        System.out.println(coll.size());    //3
        Collection coll1 = new ArrayList();
        coll1.add("BB");
        coll1.add(456);
        coll.addAll(coll1);
        coll1.clear();
        System.out.println(coll.size());    //5
        System.out.println("coll1.isEmpty() = " + coll1.isEmpty()); //true
    }

    @Test
    public void test2(){
        // 6.contains
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("AA"));
        coll.add(new Date());
        coll.add(new Person("anyang",23));
        //由于String中重写了equals方法，因此这里是true
        //而Person类没有重写equals方法，因此是false
        System.out.println(coll.contains(new String("AA")));    //true
        System.out.println(coll.contains(new Person("anyang", 23)));    //false

        //在类中Person1类中重写了equals方法，因此这里是true
        coll.add(new Person1("xin",23));
        System.out.println(coll.contains(new Person1("xin", 23)));  //true

        //7.containsAll 当前集合是否含有coll1中的所有元素
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));    //true
    }

    @Test
    public void test4(){
        //8.remove
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add("DD");
        coll.add(new Person("anyang",23));
        coll.remove(123);   //返回的是Boolean类型
        System.out.println(coll);

        //9.removeAll：从当前集合中移除coll1中的所有元素
        Collection coll1 = Arrays.asList(456,789,false);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test5(){
        //10.retainAll：当前集合和coll1集合的交集
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(false);
        coll.add("DD");
        coll.add(new Person("anyang",23));

        Collection coll1 = Arrays.asList(456,789,false);
        coll.retainAll(coll1);
        System.out.println(coll);   //[456, false]

        //11.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll2 = Arrays.asList(456,false);
        System.out.println(coll.equals(coll2)); //true
    }

    @Test
    public void test6(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());    //701070075

        //13.集合 --->数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

        //拓展：数组 --->集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1 这里把整个数组看成一个元素了
        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2

        //14.iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}