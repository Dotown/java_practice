package com.zhang.studatetime;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 一、JAVA中的对象，正常情况下，只能进行比较: == 或 != 不能使用 < 或者 >
 *     但是在实际开发场景，需要对多个对象进行排序，需要比较对象的大小。
 *     Comparable 自然排序或者Comparator 定制排序
 * 二、Comparable与 Comparator对比
 *      Comparable方式一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *      Comparator接口属于临时性比较。
 * @author Dotown
 * @create 2020-12-26-19:48
 */
public class CompareTest9 {
    /*
    Comparable接口的使用：    //自然排序
    1.String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式。
    2.重写的compareTo()从小到大进行排序。
    3.重写compareTo()的规则：
    如果当前对象this大于形参对象obj，则返回正整数，
    如果当前对象this小于形参对象obj，则返回负整数，
    如果当前对象this等于形参对象obj，则返回零。
    4.对于自定义类，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo()方法，compareTo()方法中指名如何排序。
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","GG","DD","ZZ","TT","II"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Good[] goods = new Good[5];
        goods[0] = new Good("dell", 50);
        goods[1] = new Good("hp", 45);
        goods[2] = new Good("mi", 30);
        goods[3] = new Good("hw", 45);
        goods[4] = new Good("acer", 40);
        Arrays.sort(goods); //重写compareTo方法
        System.out.println(Arrays.toString(goods)); //重写toString方法
    }

    /*
    定制排序
    Comparator接口的使用：定制排序
    1.背景：
    当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
    或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
    那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小： 如果方法返
    回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示
    o1小于o2。
     */
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","GG","DD","ZZ","TT","II"};
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);   //从大到小排序
                }
                throw new RuntimeException("比较的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Good[] goods = new Good[6];
        goods[0] = new Good("dell", 50);
        goods[1] = new Good("hp", 45);
        goods[2] = new Good("mi", 30);
        goods[3] = new Good("hw", 100);
        goods[4] = new Good("acer", 40);
        goods[5] = new Good("hw", 45);
        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Good && o2 instanceof Good){
                    Good g1 = (Good) o1;
                    Good g2 = (Good) o2;
                    if(g1.getName().equals(g2.getName())){  //名字从大到小，价格从小到大
                        return Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return -g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("比较的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
