package com.zhang.fun;
//指定参数后加...就是可变参数
//可变参数必须放在最后，且只有一个
public class Demo04 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        demo04.test(1,2,3,4,5);
    }
    public void test(int... i){
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
        }
    }
}
