package com.zhang.java;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 注解的使用：
 * 一、理解Anotation：
 * 1.jdk5.0新增的功能
 * 2.Annotation 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，并执行相应的处理。
 * 3.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 * 二、Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 三、如何自定义注解
 * 1.注解声明为:@interface
 * 2.内部定义成员，通常使用value表示
 * 3.可以指定成员的默认值，使用default定义
 * 4.如果自定义注解没有成员，表明是一个标识作用。 //Override
 * 5.如果注解有成员，在使用注解时，需要指明成员的值。
 *
 * 自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 *
 * 四、JDK提供的4种元注解
 *    元注解：对现有的注解进行解释说明的注解
 *  Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS（默认行为）\RUNTIME
 *             只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *  Target：用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *  *******出现的频率低*******
 *  Documented：表示所修饰的注解在被javadoc解析时，保留下来。
 *  Inherited：被它修饰的Annotation将具有继承性。
 *
 *  五：通过反射获取注解信息  ---到反射内容时系统讲解。
 *
 *  六：JDK8中的注解的新特性：可重复注解、类型注解
 *  1.可重复注解
 *              1.1 增加MyAnnotations类，其成员为MyAnnotation[] value();
 *              JDK8之前：
 *                     采用@MyAnnotations({@MyAnnotation("hi"),@MyAnnotation("hello")})的方式
 *              JDK8之后
 *              1.2 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *              1.3 MyAnnotation的Target和Retention等元注解与MyAnnotation相同。
 *  2.类型注解：
 *      ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *      ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 * author PC
 * create 2020-12-28-1:59
 */
@MyAnnotation(value = "hi")
public class AnnotationTest3 {
    @SuppressWarnings("unused")
    int num = 10;
    @SuppressWarnings({"unused","rawtypes"})
    ArrayList list = new ArrayList();

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]); //@com.zhang.java.MyAnnotation(value=hello)
        }
    }
}


//@MyAnnotations({@MyAnnotation("hi"),@MyAnnotation("hello")})    //JDK8之前可重复注解的写法

//JDK8之后的写法
@MyAnnotation("hi")
@MyAnnotation("hello")
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
    }
    @MyAnnotation
    public void say(){
        System.out.println("person");
    }
}

class Student extends Person{
    @Override
    public void say(){
        System.out.println("student");
    }
}

//泛型的修饰采用了JDK8的新特性  @Target(ElementType.TYPE_USE)
class Generic<@MyAnnotation T>{

    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }

}
