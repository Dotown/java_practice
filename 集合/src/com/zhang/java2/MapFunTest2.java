package com.zhang.java2;

import org.junit.Test;

import java.util.*;

/**
 *
 * 添加、 删除、修改操作：
 *   Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *   void putAll(Map m):将m中的所有key-value对存放到当前map中
 *   Object remove(Object key)：移除指定key的key-value对，并返回value
 *   void clear()：清空当前map中的所有数据
 * 元素查询的操作：
 *   Object get(Object key)：获取指定key对应的value
 *   boolean containsKey(Object key)：是否包含指定的key
 *   boolean containsValue(Object value)：是否包含指定的value
 *   int size()：返回map中key-value对的个数
 *   boolean isEmpty()：判断当前map是否为空
 *   boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 * 元视图操作的方法：
 *   Set keySet()：返回所有key构成的Set集合
 *   Collection values()：返回所有value构成的Collection集合
 *   Set  entrySet()：返回所有key-value对构成的Set集合
 *
 * 总结：常用方法：
 *   添加：put(Object key,Object value)
 *   删除：remove(Object key)
 *   修改：put(Object key,Object value)
 *   查询：get(Object key)
 *   长度：size()
 *   遍历：keySet() / values() / entrySet()
 *
 * author PC
 * create 2021-01-06-0:30
 */
public class MapFunTest2 {
    /*
    遍历
     */
    @Test
    public void test3(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,456);
        map.put("CC",789);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(values);
        }
        //遍历所有的key-value
        //方式一：entrySet()
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "--" + value);
        }
    }

    /*
    添加、 删除、修改操作：
     */
    @Test
    public void test(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,456);
        map.put("CC",789);
        map.put("AA",321);
        System.out.println(map);

        Map map1 = new HashMap();
        map.put("AA",132);  //替换了原来Map中的key相同的value
        map.put(132,123);
        map.putAll(map1);
        System.out.println(map);

        Object value = map.remove("AA");
        System.out.println(value);  //132
        System.out.println(map);

        map.clear();    //清楚了table中的元素，map并不是null
        System.out.println(map.size());
    }

    /*
    元素查询的操作

    Object get(Object key)：获取指定key对应的value
 *   boolean containsKey(Object key)：是否包含指定的key
 *   boolean containsValue(Object value)：是否包含指定的value
 *   int size()：返回map中key-value对的个数
 *   boolean isEmpty()：判断当前map是否为空
 *   boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,456);
        map.put("CC",789);
        System.out.println(map);

        //Object get(Object key)：获取指定key对应的value
        Object value = map.get("AA");
        System.out.println(value);  //123

        //boolean containsKey(Object key)：是否包含指定的key
        Boolean isExist = map.containsKey("BB");
        System.out.println(isExist);    //false

        //boolean containsValue(Object value)：是否包含指定的value
        boolean isContainValue = map.containsValue(123);
        System.out.println(isContainValue); //true

        System.out.println(map.size()); //3
        System.out.println(map.isEmpty());  //false

    }
}
