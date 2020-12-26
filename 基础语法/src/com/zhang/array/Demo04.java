package com.zhang.array;

import java.util.Arrays;

public class Demo04 {
    public static void main(String[] args) {
        int[] a = {8,5,7,9,1,3};
        int[] b = {8,5,7,9,1,3};
        int[] c = {8,5,7,9,1,3};
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));

        Arrays.sort(b);
        System.out.println(Arrays.toString(b));

        boolean flag = Arrays.equals(b,c);
        System.out.println(flag);

        int index = Arrays.binarySearch(b,3);
        System.out.println(index);
    }
}
