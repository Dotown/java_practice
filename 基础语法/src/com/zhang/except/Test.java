package com.zhang.except;

public class Test {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            System.out.println(a / b);
        }catch(ArithmeticException e){  //想要捕获的异常类型
            System.out.println("捕获异常，b不能为0");
        }catch (Error e){
            System.out.println("Error");
        }catch (Exception e){
            System.out.println("Exception");
        }catch (Throwable t){   //异常范围小的在上，大的在下，捕获到异常会直接到finally
            System.out.println("Exception");
        }
        finally {
            System.out.println("无论是否异常都会执行，可以省略");
        }
    }
}
