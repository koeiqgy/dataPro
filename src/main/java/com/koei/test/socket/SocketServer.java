package com.koei.test.socket;

/**
 * @Auther: paul
 * @Date: 2018/6/1 11:21
 * @Description:
 */
import java.awt.BorderLayout;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SocketServer extends JFrame {
    private JTextArea textArea_socketInfo;
    //声明一个显示纯文本的多行区域
    private ServerSocket server;
    //声明一个ServerSocket对象
    private Socket socket;
    //声明一个Socket对象

    public SocketServer() {
        //自定义窗体的构造方法

        super();
        //调用父类的构造方法
        setTitle("Socket Server");
        //设置窗体标题栏的内容
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体默认的关闭操作为“关闭”
        setBounds(200, 200, 280, 180);
        //设置窗体所处的位置及其大小

        final JScrollPane scrollPane = new JScrollPane();
        //声明并实例化一个带滚动条的窗格（当要显示的信息超出可视范围时，窗口将成为可滚动状态以查看更多信息）

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        //将这个窗格添加到父容器中，使用的布局方案为中间区域的布局约束（在容器的中央）

        textArea_socketInfo = new JTextArea();
        //实例化这个多行文本区域
        scrollPane.setViewportView(textArea_socketInfo);
        //将创建好的TextArea组件添加到窗格中
    }

    public void getServer() {
        try {
            server = new ServerSocket(2015);
            //实例化已声明的Socket对象，绑定的端口为2015，此端口要与客户端请求的一致
            textArea_socketInfo.append("Server socket created successfully.\n");
            //在文本区域中输出信息：服务器套接字已成功创建
            while (true) {
                //使用一个始终运行的while循环来使服务器端持续接收socket

                textArea_socketInfo.append("Waiting for connection from client...\n");
                //在文本区域中输出信息：等待客户端连接
                socket = server.accept();
                //侦听并接受到此socket的连接
                textArea_socketInfo.append("Connected successfully !\n");
                //若收到连接信息，则在在文本区域中输出信息：连接成功
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        //用异常捕获结构防止崩溃，在必要时输出异常信息
    }

    public static void main(String[] args) {
        try {
            SocketServer serverFrame = new SocketServer();
            //声明一并实例化一个窗体对象
            serverFrame.setVisible(true);
            //设置其可见
            serverFrame.getServer();
            //调用其自带的getServer()方法，来侦听并接受连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

