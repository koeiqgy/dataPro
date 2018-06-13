package com.koei.test.socket;

/**
 * @Auther: paul
 * @Date: 2018/6/1 10:47
 * @Description:
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GetNetResourceSize extends JFrame {

    private JTextField textField_size;
    private JTextField textField_url;
    //声明两个文本框控件，分别用于放置链接和资源的尺寸

    public static void main1(String args[]) {

        //用异常捕获结构防止创建窗体时出错
        try {
            GetNetResourceSize frame = new GetNetResourceSize();
            //声明一个窗体对象
            frame.setVisible(true);
            //设置窗体为可见状态
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GetNetResourceSize() {
        //自定义的窗体构造方法，继承了JFrame

        super();
        //继承父类

        setTitle("Get the size of resoure from Internet");
        //设定标题栏内容
        getContentPane().setLayout(null);
        //设置布局为空
        setBounds(200, 200, 400, 220);
        //设定窗体位置及大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体关闭时的默认操作为“关闭”

        final JLabel label_title = new JLabel();
        //新建一个标签，用于显示标题
        label_title.setForeground(Color.GREEN);
        //设置标签的前景色（字体的颜色）
        label_title.setFont(new Font("", Font.BOLD, 20));
        //设置标签的字体样式为加粗，大小为20号
        label_title.setText("Get the size of resoure from Internet");
        //设置标签内要显示的文本
        label_title.setBounds(5, 5, 400, 50);
        //设置标签的位置及其大小

        final JLabel label_title_url = new JLabel();
        label_title_url.setText("Enter URL: ");
        label_title_url.setBounds(10, 80, 80, 25);

        final JLabel label_title_size = new JLabel();
        label_title_size.setText("Size: ");
        label_title_size.setBounds(10, 125, 125, 25);
        //同上，设置了两个标签显示文本框的标题

        textField_url = new JTextField();
        textField_url.setBounds(80, 80, 286, 25);
        //实例化之前声明的这个文本框对象，并设置其位置和大小

        textField_size = new JTextField();
        textField_size.setBounds(80, 125, 145, 25);
        //同上

        final JButton button = new JButton();
        //声明并实例化了一个按钮，用于执行获取资源大小的操作
        button.setText("Get the size");
        //设置按钮上要显示的文字
        button.setBounds(235, 125, 135, 25);
        //设置按钮的位置和大小
        button.addActionListener(new ActionListener() {
            //为按钮添加事件响应，这里用到了匿名内部类
            public void actionPerformed(final ActionEvent e) {

                String url = textField_url.getText().trim();
                //获得输入的网址，调用trim()方法过滤掉前后的空格

                try{
                    long len = resourceSize(url);
                    //调用自定义的resourceSize()方法获取网络资源的大小

                    textField_size.setText(String.valueOf(len)+" byte(s)");
                    //在文本框textField_size中显示获取到的网络资源大小
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                //使用异常捕获结构防止出错
            }
        });

        getContentPane().add(label_title);
        getContentPane().add(label_title_url);
        getContentPane().add(label_title_size);
        getContentPane().add(textField_url);
        getContentPane().add(textField_size);
        getContentPane().add(button);
        //将上述所有自定义的控件添加到父容器中

    }
    // 获取url的资源
    public long resourceSize(String sUrl) throws Exception{
        URL url = new URL(sUrl);
        //创建url对象

        URLConnection urlConn = url.openConnection();
        //获得网络连接对象

        urlConn.connect();
        //连接到url指定的资源

        return urlConn.getContentLength();
        //调用getContentLength()方法，得到这个资源的大小并返回，单位为字节（long类型）
    }

    public static void main(String[] args) {
        String url="http://www.baidu.com";
        GetNetResourceSize g=new GetNetResourceSize();
        Collection<String> list=g.getURLCollection(url);
        for(String str:list){
            System.out.println(str);
        }
       // GetNetResourceSize.class.newInstance(getURLCollection(url));
    }


    public Collection<String> getURLCollection(String urlString) {
        URL url = null;
        //声明URL对象
        URLConnection conn = null;
        // 声明URLConnection通信链接对象
        Collection<String> urlCollection = new ArrayList<String>();
        //创建基于ArrayList的集合对象，元素为String类型
        try{
            url = new URL(urlString);
            //创建URL对象
            conn = url.openConnection();
            //打开连接，获得连接对象
            conn.connect();
            //连接到url引用资源，建立通信链接
            InputStream is = conn.getInputStream();
            //从连接中获取流对象，关于流对象可以参考API文档
            InputStreamReader in = new InputStreamReader(is,"UTF-8");
            //将这个流对象转换为字符流
            BufferedReader br = new BufferedReader(in);
            //将字符流转换为缓冲流对象
            String nextLine = br.readLine();
            //从缓冲流中读取信息，解析网页的内容
            while (nextLine !=null){
                urlCollection.add(nextLine);
                //解析网页的全部内容，并将他们添加到集合中
                nextLine = br.readLine();
                //循环地从缓冲流中读取信息，解析网页
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return urlCollection;
        //返回这个集合对象
    }

}
