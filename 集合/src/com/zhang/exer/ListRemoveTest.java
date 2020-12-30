package com.zhang.exer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Dotown
 * @create 2020-12-30-14:50
 */
public class ListRemoveTest {
    @Test
    public void test(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.remove(2);    //移除的是下标为2的元素
        arrayList.remove(new Integer(2));   //移除的是Integer为2的元素
        System.out.println(arrayList);
    }
}
