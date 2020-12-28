package com.zhang.java;

/**
 * @author Dotown
 * @create 2020-12-28-20:59
 */
public @interface MyAnnotation {
        String value() default "hello";
}
