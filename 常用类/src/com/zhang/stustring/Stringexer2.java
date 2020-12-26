package com.zhang.stustring;

/**
 * @author Dotown
 * @create 2020-12-24-11:21
 */
public class Stringexer2 {
    String str = "test";
    char[] chr = {'t','e','s','t'};

    void change(String str, char[] chr){
        str = "best";
        chr[0] = 'b';
    }
    public static void main(String[] args) {
        Stringexer2 s = new Stringexer2();
        s.change(s.str,s.chr);
        System.out.println(s.str);//test    String的不可变性
        System.out.println(s.chr);//best
    }
}
