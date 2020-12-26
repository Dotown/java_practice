package www.zhang.studatetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * JDK8的日期和时间的API测试
 * LocalDateTime.now()  Instant.now()    DateTimeFormatter
 *
 * @author Dotown
 * @create 2020-12-26-15:24
 */
public class DateTimeJdk88 {
    /*
    LocalDate、 LocalTime、 LocalDateTime(常用)
     */
    @Test
    public void test1(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);
        System.out.println("localDateTime = " + localDateTime);//2020-12-26T17:49:13.696


        //of：初始化设置
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 12, 26, 17, 3, 5);
        System.out.println("localDateTime1 = " + localDateTime1);

        //getXxx()
        System.out.println("localDateTime.getDayOfMonth() = " + localDateTime.getDayOfMonth());
        System.out.println("localDateTime.getDayOfYear() = " + localDateTime.getDayOfYear());
        System.out.println("localDateTime.getDayOfWeek() = " + localDateTime.getDayOfWeek());
        System.out.println("localDateTime.getMonth() = " + localDateTime.getMonth());
        System.out.println("localDateTime.getMonthValue() = " + localDateTime.getMonthValue());

        //with:设置相关属性  local体现了不可变性    Calendar是可变的
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(2);
        System.out.println("localDateTime = " + localDateTime);
        System.out.println("localDateTime2 = " + localDateTime2);

        //plus:增加
        //minus:减少

        //LocalDateTime转时间戳
        Instant instant = LocalDateTime.now().toInstant(ZoneOffset.of("+8"));
        long l = instant.toEpochMilli();
        System.out.println("l = " + l);

        //时间戳转LocalDateTime
        //1.时间戳 2.秒内的纳秒 3.时区
        LocalDateTime localDateTime3 = LocalDateTime.ofEpochSecond(1608976514894L, 0, ZoneOffset.of("+8"));
        System.out.println("localDateTime3 = " + localDateTime3);
    }


    /*
    Instant的使用
    类似于java.util.Date
     */
    @Test
    public void test2(){
        Instant instant = Instant.now();//0时区的时间
        System.out.println(instant);//2020-12-26T09:48:04.652Z

        //添加时间偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);   //2020-12-26T17:50:22.121+08:00

        //获取自1970年1月1日开始的毫秒数
        long l = instant.toEpochMilli();

        Instant instant1 = Instant.ofEpochMilli(1608902677825L);
        System.out.println("instant1 = " + instant1);

    }

    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str = dateTimeFormatter.format(LocalDateTime.now());
        System.out.println("str = " + str);
        //解析
        TemporalAccessor parse1 = dateTimeFormatter.parse("2020-12-26 05:40:55");
        System.out.println("parse1 = " + parse1); //{HourOfAmPm=5, MicroOfSecond=0, SecondOfMinute=55, MilliOfSecond=0, MinuteOfHour=40, NanoOfSecond=0},ISO resolved to 2020-12-26
    }
}
