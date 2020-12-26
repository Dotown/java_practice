package www.zhang.stustring;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author Dotown
 * @create 2020-12-25-16:01
 */
public class StringTrans4 {
    /*
    String 与基本数据类型、包装类之间的转换。
    String -->基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
              基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);
        System.out.println(num);
        String.valueOf(num);//"123"
    }

    /*
    String与char[]之间的转换
    String --> char[]   toCharArray()
    char[] --> String   调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println("charArray[i] = " + charArray[i]);
        }
        char[] chr = new char[]{'h','e','l'};
        String str2 = new String(chr);
        System.out.println(str2);
    }

    /*
    String与byte[]之间的转换
    编码：String --> buye[] 调用String的getBytes()
    解码：byte[] --> String 调用String的构造器
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//默认UTF-8编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbK");
        System.out.println(Arrays.toString(gbks));

        String str3 = new String(bytes);
        String str4 = new String(gbks);
        String str5 = new String(gbks,"gbk");
        System.out.println("str3 = " + str3);
        System.out.println("str4 = " + str4);
        System.out.println("str5 = " + str5);
    }
}
