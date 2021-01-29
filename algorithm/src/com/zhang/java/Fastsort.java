package com.zhang.java;

/**
 * 快速排序
 * author PC
 * create 2021-01-28-19:53
 */
public class Fastsort {

    public void fastsort(int[] s,int r,int l){
        if(r<l){
            int i = r;
            int j = l;
            int x = s[i];
            while (i<j){
                while (i<j && s[j]>x){
                    j--;
                }
                if (i<j){
                    s[i++] = s[j];
                }
                while (i<j && s[i]<x){
                    i++;
                }
                if(i<j){
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            fastsort(s,r,i-1);
            fastsort(s,i+1,l);
        }
    }


    public static void main(String[] args) {
        Fastsort s = new Fastsort();
        int[] arr = new int[]{7,5,9,6,8,4,1,2,3,0};
        s.fastsort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
