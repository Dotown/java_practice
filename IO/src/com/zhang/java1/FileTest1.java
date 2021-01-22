package com.zhang.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1. File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2. File类声明在java.io包下
 * 3. File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，
 *    并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流来完成。
 * 4. 后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的"终点".
 *
 *
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
     IDEA中：
     如果大家开发使用JUnit中的单元测试方法测试，相对路径即为当前Module下。
     如果大家使用main()测试，相对路径即为当前的Project下。
     Eclipse中：
     不管使用单元测试方法还是使用main()测试，相对路径都是当前的Project下。
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

    /*
public String getAbsolutePath()：获取绝对路径
public String getPath() ：获取路径
public String getName() ：获取名称
public String getParent()：获取上层文件目录路径。若无，返回null
public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
public long lastModified() ：获取最后一次的修改时间，毫秒值
如下的两个方法适用于文件目录：
public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());    //G:\JAVASE\java_practice\IO\hello.txt
        System.out.println(file1.getPath());    //hello.txt
        System.out.println(file1.getName());    //hello.txt
        System.out.println(file1.getParent());  //null
        System.out.println(file1.length()); //0
        System.out.println(file1.lastModified());   //0

        System.out.println();

        System.out.println(file2.getAbsolutePath());    //G:\io\hi.txt
        System.out.println(file2.getPath());    //d:\io\hi.txt
        System.out.println(file2.getName());    //hi.txt
        System.out.println(file2.getParent());  //d:\io
        System.out.println(file2.length()); //0
        System.out.println(file2.lastModified());   //0
    }
    @Test
    public void test3(){
        File file1 = new File("G:\\JAVASE\\java_practice");
        String[] list = file1.list();
        for (String l:list){
            System.out.println(l);
        }
        System.out.println();
        File[] files = file1.listFiles();
        for (File f:files){
            System.out.println(f);  //输出的是绝对路径
        }
    }
    /*
        public boolean renameTo(File dest):把文件重命名为指定的文件路径
         比如：file1.renameTo(file2)为例：
            要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
         */
    @Test
    public void test4(){
        File file1 = new File("G:\\JAVASE\\java_practice\\IO\\src\\com\\zhang\\java1\\hi.txt");
        File file2 = new File("hello.txt");
        boolean b = file1.renameTo(file2);
        System.out.println(b);
    }
    /*
public boolean isDirectory()：判断是否是文件目录
public boolean isFile() ：判断是否是文件
public boolean exists() ：判断是否存在
public boolean canRead() ：判断是否可读
public boolean canWrite() ：判断是否可写
public boolean isHidden() ：判断是否隐藏
     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
//        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("G:\\JAVASE\\java_practice\\IO");
        file2 = new File("G:\\JAVASE\\java_practice\\IO1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
    /*
    创建硬盘中对应的文件或文件目录
    public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
    public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
    public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
    删除磁盘中的文件或文件目录
    public boolean delete()：删除文件或者文件夹
    删除注意事项：Java中的删除不走回收站。
     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }
    }
    @Test
    public void test7(){
        //文件目录的创建
        File file1 = new File("G:\\JAVASE\\java_practice\\IO\\IO1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("G:\\JAVASE\\java_practice\\IO\\IO1\\io2");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("G:\\JAVASE\\java_practice\\IO\\IO1");
        file3 = new File("G:\\JAVASE\\java_practice\\IO\\IO1\\io2");
        System.out.println(file3.delete());
    }
}