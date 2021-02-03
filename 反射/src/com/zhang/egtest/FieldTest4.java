package com.zhang.egtest;

import com.zhang.refer.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 * author PC
 * create 2021-02-03-16:39
 */
public class FieldTest4 {
    @Test
    public void test(){
        Class clazz = Person.class;
        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for(Field f:fields){
            System.out.println(f);
        }
        System.out.println("**************************");
        //getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符  数据类型 变量名
    @Test
    public void test1(){
        Class clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field f:fields){

            System.out.print(f+":");
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+"\t");

            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName()+"\t");

            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }

    }
}
