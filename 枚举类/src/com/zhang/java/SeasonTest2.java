package com.zhang.java;

/**
 * JDK5.0之后的枚举方法
 * 经过测试默认的toString方法并不是指针，因此枚举类的父类不是Object，而是java.lang.Enum类
 *
 * author PC
 * create 2020-12-28-0:46
 */
public class SeasonTest2 {
    public static void main(String[] args) {
        Season1 winter = Season1.WINTER;
        //toString方法
        System.out.println(winter); //此时没有重写toString方法  //WINTER
        System.out.println(Season1.class.getSuperclass());  //class java.lang.Enum

        //value
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);  //SPRING SUMMER AUTUMN WINTER
            values[i].show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]); //NEW RUNNABLE BLOCKED WAITING TIMED_WAITING TERMINATED
        }

        //valueOf(String objName)
        Season1 autumn = Season1.valueOf("AUTUMN");
        //Season1 spring = Season1.valueOf("SPRING1");    //如果找不到ObjName的枚举对象，则抛出IllegalArgumentException异常
        System.out.println(autumn);

    }
}

interface Inter{
    void show();
}

enum Season1 implements Inter{

    //0.直接枚举类的对象，多个对象之间用","隔开，末尾用";"结束
    SPRING("春天","生机勃勃"){
        @Override
        public void show() {
            System.out.println("春春春春");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏夏夏夏");
        }
    },
    AUTUMN("秋天","硕果累累"){
        @Override
        public void show() {
            System.out.println("秋秋秋秋");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬冬冬冬");
        }
    };

    //2.声明对象的属性，使用private final声明
    private final String NAME;
    private final String DES;

    //1.私有化类的构造器，并给对象赋值
    private Season1(String NAME, String DES) {
        this.NAME = NAME;
        this.DES = DES;
    }

    //4.获取枚举类对象的属性
    public String getNAME() {
        return NAME;
    }
    public String getDES() {
        return DES;
    }
}
