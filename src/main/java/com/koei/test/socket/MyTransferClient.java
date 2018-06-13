package com.koei.test.socket;

import java.io.*;
import java.net.Socket;

/**
 * @Auther: paul
 * @Date: 2018/6/5 13:41
 * @Description:
 */
public class MyTransferClient {
    private static String SERVER_IP="127.0.0.1";
    private static int    PORT=8899;
    private static String FILEPATH="D:\\SSTA\\副本.txt";

    public void sendFile(){
        Socket socket=null;
        DataOutputStream out = null;
        FileInputStream fin=null;
        PrintWriter pw=null;
        byte[] bytes=new byte[1024];
        int length=0;
        try {
            File file=new File(FILEPATH);
            if(!file.exists()){
                System.out.println("上传文件不存在!");
                return;
            }
            long len=file.length();
            String name=file.getName();
            int ret;
            socket=new Socket(SERVER_IP,PORT);
            out = new DataOutputStream(socket.getOutputStream());
            fin=new FileInputStream(file);
            out.writeUTF(name);
            out.flush();
            out.writeLong(len);
            out.flush();
            out.writeUTF("========================文件信息================================");
            out.flush();
            while((length=fin.read(bytes,0,bytes.length))!=-1){
                out.write(bytes,0,length);
                out.flush();
            }
            /*
                while((ret=fin.read())!=-1){
                out.write(ret);
                out.flush();
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                fin.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }

    public static void main(String[] args) {
        MyTransferClient client=new MyTransferClient();
        client.sendFile();
    }
}
