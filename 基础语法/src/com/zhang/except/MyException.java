package com.zhang.except;

public class MyException extends Exception{
    private int a;

    public MyException(int a) {
        this.a = a;
    }

    @Override //alt enter
    public String toString() {
        return "MyException{" + "a=" + a + '}';
    }
}
