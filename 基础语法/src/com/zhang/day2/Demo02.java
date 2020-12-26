package com.zhang.day2;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        double sum = 0;
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            sum += x;
        }
        System.out.println("值的和为"+sum);
        scanner.close();
    }
}
