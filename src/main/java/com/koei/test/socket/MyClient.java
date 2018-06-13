package com.koei.test.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Auther: paul
 * @Date: 2018/6/1 13:57
 * @Description:
 */
public class MyClient {
    public static void main(String[] args) {
        String text="";
        String ret="";
        try {
            Socket socket=new Socket("127.0.0.1",10089);
            OutputStream out= socket.getOutputStream();
            InetAddress addr= socket.getLocalAddress();
            PrintWriter pw=new PrintWriter(out,true);

            text="hello  server , i'm client ,  my ip is "+addr.getHostAddress();
            pw.println(text);
            pw.println("end");
            //pw.close();
            //socket.shutdownOutput();
            InputStream in=  socket.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(in));

            while((ret=bf.readLine())!=null){
                if("end".equals(ret)) break;
                System.out.println(ret);
            }

            //byte[] bytes=text.getBytes();
            //out.write(bytes1);
            /*
            InputStream in =socket.getInputStream();
            InputStreamReader inr=new InputStreamReader(in);
            BufferedReader bfr=new BufferedReader(inr);
            while((ret=bfr.readLine())!=null){
                System.out.println(ret);
            }
            */
            //out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
