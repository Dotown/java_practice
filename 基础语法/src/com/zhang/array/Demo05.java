package com.zhang.array;

import java.util.Arrays;

public class Demo05 {
    public static void main(String[] args) {
        int[] a = {8,5,7,9,1,3};
        sort(a);
        System.out.println(Arrays.toString(a));

    }
    public static void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {

            boolean flag = false;

            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int x = array [j];
                    array[j] = array[j+1];
                    array[j+1] = x;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
