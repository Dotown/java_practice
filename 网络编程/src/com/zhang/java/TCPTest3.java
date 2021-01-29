package com.zhang.java;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 并关闭相应的连接。
 * author PC
 * create 2021-01-29-17:33
 */
public class TCPTest3 {
    @Test
    public void client(){
        OutputStream os = null;
        BufferedInputStream bif = null;
        InputStream is = null;
        ByteArrayOutputStream aos = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            Socket socket = new Socket("127.0.0.1", 8888);
            //2.获取一个输出流，用于输出数据
            os = socket.getOutputStream();
            //3.写出数据的操作
            bif = new BufferedInputStream(new FileInputStream("IO.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bif.read(buffer))!=-1){
                os.write(buffer,0,len);
            }
            socket.shutdownOutput();
            //4.接受服务器返回的流
            is = socket.getInputStream();
            aos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len1;
            while ((len1=is.read(buffer1))!= -1){
                aos.write(buffer1,0,len1);
            }
            System.out.println(aos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (aos!=null){
                try {
                    aos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bif!=null){
                try {
                    bif.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    @Test
    public void srver(){
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            ss = new ServerSocket(8888);
            //2.调用accept()表示接收来自于客户端的socket
            socket = ss.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //4.读取输入流中的数据
            bos = new BufferedOutputStream(new FileOutputStream("IO1.PNG"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            System.out.println("服务器接受完毕来组"+socket.getInetAddress().getHostAddress());   //这里是socket的方法而不是ss的方法
            //5.服务器端给予客户端反馈
            os = socket.getOutputStream();
            os.write(("收到了"+socket.getInetAddress().getHostAddress()).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭流
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }






    }
}
