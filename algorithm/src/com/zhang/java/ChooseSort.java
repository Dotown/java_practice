package com.zhang.java;

/**
 * 选择排序
 * author PC
 * create 2021-01-29-12:45
 */
public class ChooseSort {
    public void sort(int[] s){
        for (int i=0;i<s.length;i++){
            int min = i;
            for(int j= i+1;j<s.length;j++){
                if (s[j]<s[min]){
                    min =j;
                }
            }
            if(i!=min){
                int temp = s[i];
                s[i] = s[min];
                s[min] = temp;
            }
        }
    }
    public static void main(String[] args) {
        ChooseSort cs = new ChooseSort();
        int[] arr = new int[]{7,5,9,6,8,4,1,2,3,0};
        cs.sort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
