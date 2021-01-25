package com.zhang.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 *
 * 4. 可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 *
 * author PC
 * create 2021-01-25-21:50
 */
public class RandomAccessFile8 {
    @Test
    public void test1() {

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("sql.jpg"),"r");   //r为只读
            raf2 = new RandomAccessFile(new File("sql8.jpg"),"rw"); //rw为读写
            //2.
            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("random.txt","rw");
        raf1.seek(3);//将指针调到角标为3的位置
        raf1.write("xyz".getBytes());//从3开始覆盖
        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果

    //思考：将StringBuilder替换为ByteArrayOutputStream
     */
    @Test
    public void test3(){
        RandomAccessFile rw = null;
        try {
            rw = new RandomAccessFile("random.txt", "rw");
            rw.seek(3);//将指针调到角标为3的位置
            //保存指针3后面的所有数据到StringBuilder中
            byte[] data = new byte[20];
            int len;
            StringBuilder sb = new StringBuilder((int) new File("random.txt").length());
            while ((len = rw.read(data))!=-1){
                sb.append(new String(data,0,len));
            }
            //调回指针，写入“xyz”
            rw.seek(3);
            rw.write("xyz".getBytes());
            //将StringBuilder中的数据写入到文件中
            rw.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (rw!=null){
                try {
                    rw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
