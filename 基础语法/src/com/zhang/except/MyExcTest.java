package com.zhang.except;

public class MyExcTest {
    public static void main(String[] args) {
        try {
            Test(11);
        }catch (MyException e){
            //处理异常的代码块
            System.out.println(e);
        }
    }
    public static void Test(int a)throws MyException{   //抛给调用者
        System.out.println("a的值为" + a);
        if(a > 10){
            throw new MyException(a);   //传入自定义异常的参数
        }
    }
}
