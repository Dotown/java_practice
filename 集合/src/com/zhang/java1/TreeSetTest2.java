package com.zhang.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Dotown
 * @create 2020-12-30-17:11
 */
public class TreeSetTest2 {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
     */

    @Test
    public void test(){
        TreeSet treeSet = new TreeSet();
//        treeSet.add(123);
//        treeSet.add(456);
//        treeSet.add("AA");
//        System.out.println(treeSet);    //ClassCastException异常  TreeSet添加的对象必须相同。

        treeSet.add(new User("Ailun",22));
        treeSet.add(new User("Marry",13));
        treeSet.add(new User("Block",56));
        treeSet.add(new User("Jack",44));
        treeSet.add(new User("Jane",88));
        treeSet.add(new User("Marry",88));  //ClassCastException异常   需要重写对象的Comparable方法。
        //1.自然排序，User中的自然排序只比较了name，因此name为Marry的User对象，只会出现一次。这里不通过hashCode和equals判断。
        System.out.println(treeSet);

    }

    @Test
    public void test1(){
        //定制排序
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("比较的对象类型不一致");
                }
            }
        };
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.add(new User("Ailun",22));
        treeSet.add(new User("Marry",13));
        treeSet.add(new User("Block",56));
        treeSet.add(new User("Jack",44));
        treeSet.add(new User("Jane",88));
        treeSet.add(new User("Marry",88));
        //2.定制排序，此处的定制排序只比较了age。这里也不通过hashCode和equals判断。
        System.out.println(treeSet);
    }

    @Test   //结果和上边一样
    public void exer(){
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("比较的对象类型不一致");
                }
            }
        });
        treeSet.add(new User("Ailun",22));
        treeSet.add(new User("Marry",13));
        treeSet.add(new User("Block",56));
        treeSet.add(new User("Jack",44));
        treeSet.add(new User("Jane",88));
        treeSet.add(new User("Marry",88));
        System.out.println(treeSet);
    }

}
