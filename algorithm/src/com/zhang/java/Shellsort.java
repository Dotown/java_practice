package com.zhang.java;

/**
 * 希尔排序
 * author PC
 * create 2021-01-29-12:32
 */
public class Shellsort {
    public void sort(int[] s){
        for (int gap = s.length/2;gap>0;gap/=2){    //对数列分组
            for (int i = gap;i<s.length;i++){   //从gap开始依次判断
                int j;
                int temp = s[i];
                for (j=i;j>=gap&&s[j-gap]>temp;j-=gap){ //每组中大的往后移动
                    s[j] = s[j-gap];
                }
                s[j] = temp;
            }
        }
    }
}
