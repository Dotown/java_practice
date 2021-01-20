package com.zhang.java1;

import org.junit.Test;

import java.io.File;

/**
 * @author Dotown
 * @create 2021-01-20-17:13
 */
public class FileTest1 {
    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath,String childPath)
        File(File parentFile,String childPath)

    2.
    相对路径：相较于某个路径下，指明的路径。
    绝对路径：包含盘符在内的文件或文件目录的路径

    3.路径分隔符
     windows:\\
     unix:/
     可以使用File.separator作为分隔符
     */
    @Test
    public void test(){
        //构造器1
        File file1 = new File("hello.txt");//相对路径
        File file2 = new File("D:\\User_cs\\JAVA\\JavaSE\\IO\\he.txt");//绝对路径
        System.out.println(file1);
        System.out.println(file2);
        //构造器2
        File file3 = new File("D:\\User_cs\\JAVA\\JavaSE","IO");
        System.out.println(file3);
        //构造器3
        File file4 = new File(file3,"he.txt");
        System.out.println(file4);
    }


}
