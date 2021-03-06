package com.zhang.java;

import java.lang.annotation.*;

/**
 * @author Dotown
 * @create 2020-12-28-20:59
 */
@Inherited
@Repeatable(MyAnnotations.class)        //JDK8之后的声明方式
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE_USE})

public @interface MyAnnotation {
        String value() default "hello";
}
