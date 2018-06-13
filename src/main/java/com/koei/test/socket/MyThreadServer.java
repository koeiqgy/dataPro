package com.koei.test.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Thread2 implements  Runnable{
    private Socket socket;
    public Thread2(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            int ret;
            String str="";
            String str2="hello client , i m host , i know your ip is"+socket.getInetAddress().getAddress().toString();
            InputStream ins= socket.getInputStream();
            InputStreamReader inread= new InputStreamReader(ins);
            BufferedReader bf=new BufferedReader(inread);
            //str= bf.readLine();

            while((str=bf.readLine())!=null){
                if("end".equals(str)) break;
                System.out.println(str);
            }

            System.out.println("server 处理read 完毕");

            OutputStream out =socket.getOutputStream();
            PrintWriter pw=new PrintWriter(out,true);
            pw.println(str2);
            pw.println("end");
            //socket.close();
                /*
                OutputStream out=socket.getOutputStream();
                OutputStreamWriter ow=new OutputStreamWriter(out);
                BufferedWriter bw=new BufferedWriter(ow);
                bw.write(str2);
                */
            //bf.close();
            //bw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}



/**
 * @Auther: paul
 * @Date: 2018/6/7 13:15
 * @Description:
 */
public class MyThreadServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new  ServerSocket(10089);
            while (true){
                Socket socket=server.accept();
                new Thread(new Thread2(socket)).start();
            }
            //bf.close();
            //socket.close();
            // server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
