package com.zhang.java;

/**
 * 插入排序
 * author PC
 * create 2021-01-29-12:22
 */
public class Charusort {
    public void sort(int[] s){
        for (int i = 1; i<s.length;i++){    //选择的下一个元素
            int temp = s[i];
            int j;
            for(j = i;j>0&&s[j-1]>temp; j--){   //下一个元素与前边艺排好序元素的比较
                s[j] = s[j-1];
            }
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        Charusort cs = new Charusort();
        int[] arr = new int[]{7,5,9,6,8,4,1,2,3,0};
        cs.sort(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
