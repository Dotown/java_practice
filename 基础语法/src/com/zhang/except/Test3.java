package com.zhang.except;

public class Test3 {

    public static void main(String[] args) {
        new Test3().test(0,1);
    }


    //假设这个方法中，处理不了这个异常，就通过throws向调用者抛出异常，调用者使用try catch捕获
    public void test(int a,int b) throws ArithmeticException{
        if (b == 0){
                throw new ArithmeticException();    //主动抛出异常
        }
    }
}
