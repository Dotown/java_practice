package com.zhang.array;

public class Demo01 {
    public static void main(String[] args) {
        int[] nums;//1.声明
        nums = new int[10];//创建数组

        //静态初始化
        int[] a= {1,2,3};
        Man[] c = {new Man(1,2), new Man(3,4)};
        //动态初始化
        int[] b =new int[2];
        a[0] = 1;
        a[1] = 2;
    }
}
