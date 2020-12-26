package com.zhang.array;

public class Demo06 {
    //稀疏数组
    public static void main(String[] args) {
        int[][] array = new int[10][11];
        array[1][2] = 1;
        array[2][3] = 2;
        printArray(array);
        //转换为稀疏数组
        int[][] a = newArray(array);
        printArray(a);
    }
    public static int[][] newArray(int[][] array){
        //获取有效值的个数
        int sum = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if(anInt != 0){
                    sum++;
                }
            }
        }
        //构建稀疏数组
        int[][] arr = new int[sum+1][3];
        arr[0][0] = array.length;
        arr[0][1] = array[0].length;
        arr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < arr[0][0]; i++) {
            for (int j = 0; j < arr[0][1]; j++) {
                if(array[i][j] != 0){
                    count++;
                    arr[count][0] = i;
                    arr[count][1] = j;
                    arr[count][2] = array[i][j];
                }
            }
        }
        return arr;
    }
    public static void printArray(int[][] array){
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println("");
        }
    }
}
