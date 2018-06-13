package com.koei.test.socket;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @Auther: paul
 * @Date: 2018/6/1 14:54
 * @Description:
 */
public class Client {

    public static void main(String args[]) throws Exception {
        String host = "127.0.0.1";
        int port = 8089;
        Socket socket = new Socket(host,port);

        Writer writer = new OutputStreamWriter(socket.getOutputStream());
        writer.write("Hello Server,i'm c1");
        writer.write("eof");
        writer.flush();

        writer.close();
        socket.close();

    }
}
