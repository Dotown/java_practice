package com.zhang.eg;

import java.io.Serializable;

/**
 * author PC
 * create 2021-02-03-16:27
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
