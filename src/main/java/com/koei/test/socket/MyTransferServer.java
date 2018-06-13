package com.koei.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: paul
 * @Date: 2018/6/5 13:41
 * @Description:
 */
public class MyTransferServer {
    private static int  PORT=8899;
    private static String FilePath="D:\\SSTA\\副本1621.txt";
    private ServerSocket server;
    private Socket  socket;
    private InputStream ins;
    private FileOutputStream out;
    private DataInputStream dainput;
    private int ret;
    private byte[] bytes=new byte[1024];
    int lens=0;
    public void init (){
        try {
            server=new ServerSocket(PORT);
            while(true){
                socket=server.accept();
                ins= socket.getInputStream();
                dainput=new DataInputStream(ins);
                out=new FileOutputStream(FilePath);
                String filename=dainput.readUTF();
                long len=dainput.readLong();
                String info=dainput.readUTF();
                System.out.println("filename "+filename);
                System.out.println("len "+len);
                System.out.println("info"+info);
                while((lens =dainput.read(bytes,0,bytes.length))!=-1){
                  out.write(bytes,0,lens);
                  out.flush();
                }
/*              while((ret=dainput.read())!=-1){
                    out.write(ret);
                    out.flush();
                }*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ins.close();
                out.close();
                dainput.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTransferServer server=new MyTransferServer();
        server.init();
    }

}
