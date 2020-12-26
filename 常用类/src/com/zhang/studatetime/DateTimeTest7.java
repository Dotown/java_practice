package com.zhang.studatetime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK8之前日期和时间的API测试
 *
 * @author Dotown
 * @create 2020-12-25-21:12
 */
public class DateTimeTest7 {
    @Test
    public void test1(){
        long time = System.currentTimeMillis(); //毫秒为单位的时间差。时间戳
        System.out.println("time = " + time);
    }
    /*
    java.util.Date类
        java.sql.Date类
    1.两个构造器的使用
        1.Date():
        2.指定毫秒数的Date对象
    2.两个方法的使用
        1.toString():显示当前的年月日时分秒
        2.getTime():获取当前Date对象对应的毫秒数（时间戳）
     */
    @Test
    public void test2(){
        //
        //util  构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 =new Date();
        System.out.println("date1.toString() = " + date1.toString());//Fri Dec 25 21:24:37 CST 2020
        System.out.println("date1.getTime() = " + date1.getTime());//1608902677825
        Date date2 = new Date(1608902677825L);//指定毫秒数的Date对象

        java.sql.Date date3 = new java.sql.Date(1608902677825L);
        System.out.println("date3.toString() = " + date3.toString());//2020-12-25

    }

    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    
    1.两个操作：
    1.1 格式化：日期-->字符串
    1.2 解析：格式化的逆过程
    2.SimpleDateFormat的实例化
 */
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date1 = new Date();
        System.out.println("date1 = " + date1);//Fri Dec 25 22:03:32 CST 2020
        
        //格式化
        String format = sdf.format(date1);
        System.out.println("format = " + format);//20-12-25 下午10:03
        //解析
        String s = "20-12-25 下午10:03";
        Date date2 = sdf.parse(s);
        System.out.println("date2 = " + date2);//Fri Dec 25 22:03:00 CST 2020

        //按指定的方式进行格式化：调用带参数的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//hh为12小时制的小时
        //格式化
        Date date3 = new Date();
        String s3 = sdf1.format(date3);
        System.out.println("s3 = " + s3);//2020-12-25 10:19:05
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式
        String s4 = "2020-12-25 10:19:05";
        Date date4 = sdf1.parse(s4);
        System.out.println("date4 = " + date4);//Fri Dec 25 10:19:05 CST 2020
    }

    /*
    三天打鱼  1990-01-01  问2020-12-16在打鱼还是晒网
     */
    @Test
    public void test4() throws ParseException {

        SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
        String str4 = "1990-01-01";
        Date date4 = sdf4.parse(str4);
        Date date5 = new Date();
        long time = date5.getTime() - date4.getTime();
        long day = time/(1000*60*60*24);
        long answer = day%5;
        if (answer <= 3){
            System.out.println("打鱼");
        }else{
            System.out.println("晒网");
        }

    }

    /*
    Calendar日历类(抽象类)的使用
     */
    @Test
    public void testCalender(){
        //1.实例化
        //方式一：调用子类(GregorianCalendar)的对象
        //方式二：调用其静态方法getInstance()
        Calendar ca = Calendar.getInstance();
        System.out.println(ca.getClass());//返回该对象被生成的类

        //2.常用方法
        //get()
        int day = ca.get(Calendar.DAY_OF_MONTH);
        System.out.println("day = " + day);
        //set()
        ca.set(Calendar.DAY_OF_MONTH,22);   //void本身修改了
        System.out.println("ca.get(Calendar.DAY_OF_MONTH) = " + ca.get(Calendar.DAY_OF_MONTH));

        //add()
        ca.add(Calendar.DAY_OF_MONTH,5);
        System.out.println("ca.get(Calendar.DAY_OF_MONTH) = " + ca.get(Calendar.DAY_OF_MONTH));

        //getTime()
        Date date = ca.getTime();
        System.out.println("date = " + date);

        //setTime()
        ca.setTime(date);
        day = ca.get(Calendar.DAY_OF_YEAR);
        System.out.println("day = " + day);
        /*
        获取月份时：一月是0，12月是11
        获取星期时：周日是1，周六是7
         */
    }


}
