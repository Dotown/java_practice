package com.zhang.except;

public class Test2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;

        try {
            System.out.println(a/b);//Ctrl Alt T
        } catch (Exception e) {
            e.printStackTrace();//打印错误的的栈信息
            System.exit(1);//
        } finally {
        }
    }


}
