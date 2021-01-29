package com.zhang.java;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDPd协议的网络编程
 * author PC
 * create 2021-01-29-18:22
 */
public class UDPTest {
    @Test
    public void client(){
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            String str = "UDP方式发送的内容";
            byte[] buffer = str.getBytes();

            DatagramPacket dp = new DatagramPacket(buffer,0,buffer.length,InetAddress.getByName("127.0.0.1"),8888);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds!=null){
                ds.close();
            }
        }
    }
    @Test
    public void server(){
        DatagramSocket socket = null;   //服务器端设置端口号
        try {
            socket = new DatagramSocket(9090);

            byte[] buffer = new byte[100];  //建立一个空packet
            DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

            socket.receive(packet);     //接受packet

            System.out.println(new String(packet.getData(),0,packet.getLength()));  //packet输出
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null){
                socket.close();
            }
        }
    }
}
