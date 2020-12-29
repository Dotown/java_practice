package com.zhang.java;

import java.lang.annotation.*;

/**
 * author PC
 * create 2020-12-29-14:51
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE_USE})
public @interface MyAnnotations{
    MyAnnotation[] value(); //这是一种成员变量
}
