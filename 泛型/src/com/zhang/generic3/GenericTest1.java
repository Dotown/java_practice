package com.zhang.generic3;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 1.泛型在继承方面的体现
 * @author Dotown
 * @create 2021-01-20-14:34
 */
public class GenericTest1 {
    /*
    1. 泛型在继承方面的体现
      虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
       补充：类A是类B的父类，A<G> 是 B<G> 的父类
     */

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        //此时的list1和list2的类型不具有子父类关系
        //编译不通过
        //list1 = list2;
    }
    @Test
    public void test2(){
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;
        list1 = list3;
        list2 = list3;
    }

    /*
    2.通配符的使用
    通配符：？
    类A是类B的父亲，G<A>和G<B>是没有关系的，二者共同的父类是：G<?>
     */
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        list = list3;
        //编译不通过，
        //添加(写入)：对于List<?>就不能向其内部添加数据
        //除了添加null外
//        list.add("DD");
        list.add(null);
        //读取
        Object o = list.get(0);
        print(list);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    /*
    3.有限制条件的通配符的使用
        ? extends T:  限定参数类型的上界：参数类型必须是T或T的子类型
        只能用于方法返回，告诉编译器此返参的类型的最小继承边界为T，T和T的父类都能接收，但是入参类型无法确定，只能接受null的传入
        ? super T:  限定参数类型的下界：参数类型必须是T或T的超类型
        只能用于限定方法入参，告诉编译器入参只能是T或其子类型，而返参只能用Object类接收
     */
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Person> list3 = new ArrayList<>();
        List<Student> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();

        list1 = list3;
        list1 = list4;
        //编译不通过
//        list1 = list5;

        list2 = list3;
        //编译不通过
//        list2 = list4;
        list2 = list5;



        //? extends T  ----写入：
        //不能放入任何类型，因为编译器只知道list1中应该放入Person的某个子类，但具体放哪种子类它并不知道，因此，除了null以外，不能放入任何类型
//        list1.add(new Person());
//        list1.add(new Student());
        //? extends T  ----读取：
        //因为<? extends T> 只能用于方法返回，告诉编译器此返参的类型的最小继承边界为T，T和T的父类都能接收
        Person person = list1.get(0);
        Object person2 =list2.get(0);

        //? super T   ----写入：
        //只能放入T类型，且满足T类型的超类至少是Preson，换句话说，就是只能放入Person的子类型
        list2.add(new Person());
        list2.add(new Student());
//        list2.add(new Object());
        //? super T   ----读取：
        //返回类型是未知的， 因为<? super T>只能用于限定方法入参，告诉编译器入参只能是T或其子类型，而返参只能用Object类接收
//        Person p1 = list2.get(0);
//        Student s1 = list2.get(0);
    }
}
