package com.zhang.struct.demo06;

//抽象接口
public abstract class Action {

    //抽象方法，必须在子类中去实现
    public abstract void someThing();

    //1.抽象类不能new，只能靠子类去实现
    //2.抽象类也可以写普通的方法
    //3.抽象方法必须在抽象类中

    //抽象类也有构造函数

}