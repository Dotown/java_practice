package com.zhang.fun;

public class Demo05 {
    public static void main(String[] args) {
        int n = f(10);
        System.out.println(n);
    }
    //边界条件：边界
    //前阶段
    //返回阶段

    public static int f(int x){
        if(x==1){
            return 1;
        }else{
            return x*f(x-1);
        }
    }
}
