package com.zhang.java;

/**
 * 一、枚举类的使用
 * 1.枚举类的理解:类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式。
 *
 * 二、如何定义枚举类
 * 1.JDK5.0之前，自定义枚举类
 * 2.JDK5.0之后，可以使用enum定义枚举类
 *
 * 三、Enum类中的常用方法
 * values()方法:返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 * valueOf(String str):可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”
 * 如不是，会有运行时异常:IllegalArgumentException。
 * toString():返回当前枚举类对象常量的名称
 *
 * 四、使用Enum关键字定义的枚举类实现接口的情况
 * 1.实现接口，在Enum类中去实现抽象方法
 * 2.让枚举类的对象分别去实现接口中的抽象方法
 *
 * author PC
 * create 2020-12-28-0:24
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        //4.直接使用类中的对象
        Season spring = Season.SPRING;
        System.out.println(spring); //Season{NAME='春天', DES='生机勃勃'}
    }
}
class Season{
    //2.声明对象的属性，使用private final声明
    private final String NAME;
    private final String DES;

    //1.私有化类的构造器，并给对象赋值
    private Season(String NAME, String DES) {
        this.NAME = NAME;
        this.DES = DES;
    }

    //3.提供当前类的多个枚举对象：public static final的
    public static final Season SPRING = new Season("春天","生机勃勃");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","硕果累累");
    public static final Season WINTER = new Season("冬天","冰天雪地");

    //4.获取枚举类对象的属性
    public String getNAME() {
        return NAME;
    }
    public String getDES() {
        return DES;
    }

    @Override
    public String toString() {
        return "Season{" +
                "NAME='" + NAME + '\'' +
                ", DES='" + DES + '\'' +
                '}';
    }
}
