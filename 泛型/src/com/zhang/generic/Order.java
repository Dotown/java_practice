package com.zhang.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 * 1.构造函数不需要带泛型
 * 2.public T getDataT()不是泛型方法
 * 3.静态方法中不能使用类的泛型
 * 4.异常类不能是泛型
 * 5.不能直接new一个泛型
 *
 * @author Dotown
 * @create 2021-01-15-17:05
 */
public class Order<T> {
    String name;
    int age;
    //类的内部结构可以使用类的泛型
    T dataT;

    //1.构造函数不需要带泛型
    public Order(){
        //5.不能直接new一个泛型
        //T[] arr = new T[10];
        T[] arr = (T[]) new Object[10]; //如果有必要，则这样写。且必须满足T是Object的子类
    }

    public Order(String name, int age, T dataT){
        this.name = name;
        this.age = age;
        this.dataT = dataT;
    }
    public void setDataT(T dataT){
        this.dataT = dataT;
    }
    //getDataT不是泛型方法
    public T getDataT(){
        return dataT;
    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> test(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for (E e:arr){
            list.add(e);
        }
        return list;
    }

    //静态方法中不能使用类的泛型
//    public static void show(T dataT){
//        System.out.println(dataT);
//    }

    public void show(){
        //编译错误
//        try {
//
//        }catch (T t){
//
//        }
    }
}

//异常类不能是泛型
//class MyException<T> extends Exception{ }
