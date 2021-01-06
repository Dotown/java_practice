package com.zhang.java2;

import com.zhang.java1.User;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Dotown
 * @create 2021-01-06-12:38
 */
public class TreeMapTest3 {
    @Test
    public void test(){

        User u1 = new User("Tom", 55);
        User u2 = new User("Jack", 33);
        User u3 = new User("Tam", 44);
        User u4 = new User("Kac", 18);

        TreeMap treeMap = new TreeMap();
        treeMap.put(u1,99);
        treeMap.put(u2,88);
        treeMap.put(u3,94);
        treeMap.put(u4,100);

        Set set = treeMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
