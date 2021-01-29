package com.zhang.java;

/**
 * author PC
 * create 2021-01-29-13:41
 */
public class HeapSort {
    public void swap(int[] s, int i, int j){
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public void heapify(int[] s, int i, int l){
        int left = i*2+1;
        int right = i*2+2;
        int max = i;
        if(left<l&&s[left]>s[max]){
            max = left;
        }
        if (right<l&&s[right]>s[max]){
            max = right;
        }
        if(max!=i){
            swap(s,i,max);
            heapify(s,max,l);
        }
    }
    public void buildMaxHeap(int[] s, int l){
        for (int i = l/2-1;i>=0;i--){
            heapify(s,i,l);
        }
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] arr = new int[]{7,5,9,6,8,4,1,2,3,0};
        int len = arr.length;
        hs.buildMaxHeap(arr,len);    //构建最大顶堆
        for(int i : arr){
            System.out.println(i);
        }
        for(int i = len-1;i>0;i--){
            hs.swap(arr,0,i);
            len--;
            hs.heapify(arr,0,len);
        }
    }
}
