package com.zhang.java;

import org.junit.Test;

import java.util.*;

/**
 * 一、List接口框架
 *    |----Collection接口：单列集合，用来存储一个一个的对象
 *        |----List接口：存储有序的、可重复的数据。  -->“动态”数组,替换原有的数组
 *            |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高；底层使用Object[] elementData存储
 *            |----LinkedList：对于频繁的插入、删除操作，使用此类效率比ArrayList高；
 *            |----Vector：作为List接口的古老实现类；线程安全的，效率低；底层使用Object[] elementData存储
 *
 * 二、ArrayList的源码分析
 *    2.1 JDK7情况下
 *        ArrayList list = new ArrayList();//底层创建了长度是10的Object[]数组elementData
 *        list.add(123);//elementData[0] = new Integer(123);
 *        ...
 *        list.add(11);//如果此次的添加导致底层elementData数组容量不够，则扩容。
 *        默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *        结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *    2.2 jdk 8中ArrayList的变化：
 *        ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}.并没有创建长度为10的数组
 *        list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData[0]
 *        ...
 *        后续的添加和扩容操作与jdk 7 无异。
 *    2.3 小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8中的ArrayList的对象
 *            的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 * 三、LinkedList的源码分析：
 *    LinkedList list = new LinkedList(); 内部声明了Node类型的first和last属性，默认值为null
 *    list.add(123);//将123封装到Node中，创建了Node对象。
 *    Node(Node<E> prev, E element, Node<E> next)   //体现了LinkedList的双向链表的说法
 *
 * 四、Vector的源码分析：
 *    jdk7和jdk8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组。在扩容方面，默认扩容为原来的数组长度的2倍。
 *
 * 面试题：ArrayList、LinkedList、Vector三者的异同？
 *    同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *    不同：见上
 *
 * 五、List接口中的常见方法
 *
 *
 * @author Dotown
 * @create 2020-12-30-10:34
 *
 */
public class ListTest5 {
    /*
    void add(int index, Object ele):在index位置插入ele元素
    boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    Object get(int index):获取指定index位置的元素
    int indexOf(Object obj):返回obj在集合中首次出现的位置
    int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    Object remove(int index):移除指定index位置的元素，并返回此元素
    Object set(int index, Object ele):设置指定index位置的元素为ele
    List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

    总结：
        增：add(Object obj)
        删：remove(int index) / remove(Object obj)
        改：set(int index, Object ele)
        查：get(int index)
        插：add(int index, Object ele)
        长度：size()
        遍历：1.Iterator迭代器方式
             2.增强for循环
             3.size和get
     */

    @Test   //遍历
    public void test3(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(false);
        arrayList.add(new Person("fan",12));

        //方式一：
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //方式二：
        for(Object obj : arrayList){
            System.out.println(obj);
        }
        //方式三
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    @Test
    public void test(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(false);
        arrayList.add(new Person("fan",12));
        arrayList.add(1,"insert");
        System.out.println(arrayList.size());//5

        List list = Arrays.asList(789,new Date());
        arrayList.addAll(3,list);
        System.out.println(arrayList);
    }

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(false);
        arrayList.add(new Person("fan",12));
        System.out.println(arrayList.get(2));   //false
        System.out.println(arrayList.indexOf(123)); //0
        arrayList.add(3,123);
        System.out.println(arrayList.lastIndexOf(123)); //3
    }

    @Test
    public void test2(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(123);
        arrayList.add(456);
        arrayList.add(false);
        arrayList.add(new Person("fan",12));
        arrayList.remove(3);
        System.out.println(arrayList);  //[123, 456, false]

        arrayList.set(0,789);
        System.out.println(arrayList);  //[789, 456, false]

        List list = arrayList.subList(1, 3);
        System.out.println(list);   //[456, false]
    }
}
