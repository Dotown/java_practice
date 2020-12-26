package com.zhang.day1;

public class Demo03 {
    public static void main(String[] args) {
        //整数扩展： 进制  二进制0b   十进制    十八进制0    十六进制0x
        int i1 = 1;
        int i2 = 010;
        int i3 = 0x10;
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);

        /*浮点数扩展： 银行业务表示？
        最好避免浮点数比较
        BigDecimal
         */
        float f = 0.1f;
        double d = 0.1;
        System.out.println(f==d);   //false

        float d1 = 123456789f;
        float d2 = d1+1;
        System.out.println(d1==d2); //true

        /*强制转换可以将所有的字符转换为数字
        unicode 2字节 65536
        97=a 65=A
        专一字符：
        \t  制表符
        \n  换行
         */
        char c1 ='a';
        char c2= '中';
        char c3 = '\u0061';
        System.out.println((int)c1);//97
        System.out.println((int)c2);//20013
        System.out.println(c3); //a

        // 字符串扩展
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1==s2);//false
        String s3 = "Hello";
        String s4 = "Hello";
        System.out.println(s3==s4);//true
    }
}
