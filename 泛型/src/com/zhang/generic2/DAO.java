package com.zhang.generic2;

import java.util.List;

/**
 * data access object 将 数据库和对象链接
 *
 * @author Dotown
 * @create 2021-01-16-16:26
 */
public class DAO<T> {  //表的共性操作的DAO
    //添加一条记录
    public void add(T t){}
    //删除一条记录
    public void update(int index,T t){}
    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录
    public List<T> getForList(int index){
        return null;
    }
    //泛型方法
    public <E> E getValue(){
        return null;
    }
    
}
