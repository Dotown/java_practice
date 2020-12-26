package com.zhang.array;

public class Demo03 {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5};
        int[] re = reverse(arrays);
        pri(re);
    }
    public static int[] reverse(int[] arr){
        int[] re = new int[arr.length];
        for (int i = 0, j = arr.length-1; i < arr.length; i++,j--) {
            re[j] = arr[i];
        }
        return re;
    }
    public static void pri(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
