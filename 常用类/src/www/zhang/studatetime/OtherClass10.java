package www.zhang.studatetime;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Dotown
 * @create 2020-12-26-21:07
 */
public class OtherClass10 {
    @Test
    public void test(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);//1.8.0_271
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);//D:\env\jdk1.8\jre
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);//Windows 10
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);//10.0
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);//Zhang
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);//C:\Users\Zhang
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);//D:\User_cs\JAVA\JavaSE\常用类
    }

    /*
    public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。
    BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger
    BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger
    BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger
    BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数相除只保留整数部分。
    BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。
    BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟(this % val) 的两个 BigInteger 的数组。
    BigInteger pow(int exponent) ：返回其值为 (thisexponent) 的 BigInteger。
*/
    @Test
    public void test2(){
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        // System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));//scale为精度，BigDecimal.ROUND_HALF_UP四舍五入模式
    }
}
