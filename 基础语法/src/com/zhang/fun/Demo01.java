package com.zhang.fun;
// 重构就是函数名一致，但是参数的类型、个数、顺序不一致即可
public class Demo01 {
    public static void main(String[] args) {
        int x = add(1, 2);
        System.out.println(x);

    }

    public static int add(int a,int b){
        return a+b;
    }
    public static int add(double a, double b){
        return (int)a + (int)b;
    }
}
