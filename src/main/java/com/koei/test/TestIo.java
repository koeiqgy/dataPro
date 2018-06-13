package com.koei.test;

import java.io.*;

public class TestIo {
    /*
    public void copy(InputStream in, OutputStream out) throws IOException {
        byte[] buf = new  byte[4096];
        int len = in.read(buf);
        //read 将输入流字节数 读取到 字节数组中
        while (len != -1){
            out.write(buf, 0, len);
            len = in.read(buf);
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        TestIo t = new TestIo();
        System.out.println("输入字符：");
        t.copy(System.in, System.out);
    }
    */

    /**
     * 功能描述:
     * 复制控制台输入信息，并在控制台打印
     * @param: [in, out]
     * @return: void
     * @auther: qiugy
     * @date: 2018/5/31 10:05
     */
    public static void copy(InputStream in ,OutputStream out) throws  IOException{
        int ret=0;
        byte[] bytes=new byte[4096];
        ret=in.read(bytes);
        while(ret!=-1){
            out.write(bytes,0,ret);
            ret=in.read(bytes);
        }
        out.close();
        in.close();
    }

    /**
     * 功能描述:
     * 文件IO读取写入
     * @param: []
     * @return: void
     * @auther: qiugy
     * @date: 2018/5/31 10:38
     */
    public static  void fileIO(String finp,String foutp){
        String finPath=finp;
        String foutPath=foutp;
        FileInputStream fin=null;
        FileOutputStream fout=null;
        int ret;
        try {
            fin=new FileInputStream(finPath);
            fout=new FileOutputStream(foutPath);
            while((ret=fin.read())!=-1){
                fout.write(ret);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fin.close();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 功能描述:
     * main方法
     * @param: [args]
     * @return: void
     * @auther: qiugy
     * @date: 2018/5/31 10:19
     */
    public static void main1(String[] args) throws IOException{
        System.out.println("请输入字符");
        copy(System.in,System.out);
    }

    /**
     * 功能描述: 
     *
     * @param: 
     * @return: 
     * @auther: qiugy
     * @date: 2018/5/31 14:18
     */
    public static void main2(String[] args) {
        String finPath="E:\\test\\1.txt";
        String foutPath="E:\\test\\2.txt";
        fileIO(finPath,foutPath);
    }

    /**
     * 功能描述:
     * 缓冲流读写文件
     * @param: [args]
     * @return: void
     * @auther: qiugy
     * @date: 2018/5/31 14:18
     */
    public static void main(String[] args) {
        String finPath="E:\\test\\1.txt";
        String foutPath="E:\\test\\3.txt";
        BufferedInputStream bufferin=null;
        BufferedOutputStream bufferout=null;
        int ret;
        try {
            bufferin=new BufferedInputStream(new FileInputStream(finPath));
            bufferout=new BufferedOutputStream(new FileOutputStream(foutPath));
            while((ret=bufferin.read())!=-1){
                bufferout.write(ret);
            }
            bufferout.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        finally {
            try {
                bufferin.close();
                bufferout.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }





}
