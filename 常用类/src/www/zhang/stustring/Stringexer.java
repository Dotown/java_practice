package www.zhang.stustring;

/**
 * @author Dotown
 * @create 2020-12-24-11:21
 */
public class Stringexer {
    String str = "test";
    char[] chr = {'t','e','s','t'};

    void change(String str, char[] chr){
        str = "best";
        chr[0] = 'b';
    }
    public static void main(String[] args) {
        Stringexer s = new Stringexer();
        s.change(s.str,s.chr);
        System.out.println(s.str);//test    String的不可变性
        System.out.println(s.chr);//best
    }
}
