package com.zhang.debug;

import org.junit.Test;

/**
 * @author Dotown
 * @create 2020-12-25-21:43
 */
public class IDEADebug6 {
    @Test
    public void test(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//  4
        System.out.println(sb);//   "null"

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//空指针异常
    }
}
