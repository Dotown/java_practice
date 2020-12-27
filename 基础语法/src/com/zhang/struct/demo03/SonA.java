package com.zhang.struct.demo03;

public class SonA extends FatherB {
//    public static void test(){
//        System.out.println("A-test");
//    }


    @Override//有功能的注释！
    public void test() {
        super.test();
    }
    public void eat(){
        System.out.println("eat");
    }
}
