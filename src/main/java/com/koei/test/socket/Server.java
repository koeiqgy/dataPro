package com.koei.test.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: paul
 * @Date: 2018/6/1 14:53
 * @Description:
 */
public class Server {

    public static void main(String args[]) throws IOException {
        //为了简单起见，所有的异常信息都往外抛

        int port = 8089; //define ServerSocket listen port 8080
        ServerSocket server = new ServerSocket(port);


        Socket socket = server.accept(); //server try to accept other Socket's connection request  , server's accept method is block

        //connect with client ,then we can get the InputStream of socket which we can get message of client
        Reader reader = new InputStreamReader(socket.getInputStream());

        char chars[] = new char[64];
        int len;
        String temp;
        int index;
        StringBuilder sb = new StringBuilder();
        while ((len=reader.read(chars)) != -1) {
            temp = new String(chars,0,len);
            if((index=temp.indexOf("eof")) != -1){
                sb.append(temp.substring(0, index));
                break;
            }
            // sb.append(new String(chars, 0, len));
        }
        System.out.println("from client: " + sb);

        reader.close();
        socket.close();
        server.close();
    }

}
