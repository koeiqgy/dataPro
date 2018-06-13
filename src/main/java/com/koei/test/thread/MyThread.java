package com.koei.test.thread;

import java.io.*;

/**
 * @Auther: paul
 * @Date: 2018/6/8 08:59
 * @Description:
 */
class ThreadRun implements  Runnable{
    private String fileStr;
    public ThreadRun(String fileStr) {
        this.fileStr=fileStr;
    }
    @Override
    public void run() {
        byte [] bytes=new byte[1024];
        char [] chars=new char[1024];
        int len;
        //doSomeThing();  //测试的代码段
        long startTime=System.currentTimeMillis();   //获取开始时间
        try {
                FileInputStream fins=new FileInputStream(fileStr);
                /*
                BufferedInputStream bins=new BufferedInputStream(fins);
                while((len=bins.read(bytes,0,bytes.length))!=-1){
                    System.out.println(new String(bytes));
                }*/
                /*
                BufferedReader bf=new BufferedReader(new InputStreamReader(fins));
                while((len=bf.read(chars,0,chars.length))!=-1){
                    System.out.println(new String(chars));
                }*/
                // 1.4s 读取
                long startTime1=System.currentTimeMillis();   //获取开始时间
                while((len=fins.read(bytes,0,bytes.length))!=-1){
                    //System.out.println(new String(bytes));
                }
                long endTime1=System.currentTimeMillis();   //获取开始时间
                System.out.println("文件读取时间： " +(endTime1-startTime1)/1000.00 +"s");
                //dosth. 3s
                Thread.sleep(3000);
                System.out.println("文件处理时间： " +3 +"s");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " +(endTime-startTime)/1000.00 +"s");
    }
}



public class MyThread {
    //private static String FilePath="D:\\download\\VMware-workstation-full-12.5.7.20721.exe";
    public void readIO(String FilePath[]){
        byte [] bytes=new byte[1024];
        char [] chars=new char[1024];
        int len;
        //doSomeThing();  //测试的代码段
        long startTime=System.currentTimeMillis();   //获取开始时间
        try {
            for(String fileStr:FilePath){
                FileInputStream fins=new FileInputStream(fileStr);
                /*
                BufferedInputStream bins=new BufferedInputStream(fins);
                while((len=bins.read(bytes,0,bytes.length))!=-1){
                    System.out.println(new String(bytes));
                }*/
                /*
                BufferedReader bf=new BufferedReader(new InputStreamReader(fins));
                while((len=bf.read(chars,0,chars.length))!=-1){
                    System.out.println(new String(chars));
                }*/
                // 1.4s 读取
                long startTime1=System.currentTimeMillis();   //获取开始时间
                while((len=fins.read(bytes,0,bytes.length))!=-1){
                    //System.out.println(new String(bytes));
                }
                long endTime1=System.currentTimeMillis();   //获取开始时间
                System.out.println("文件读取时间： " +(endTime1-startTime1)/1000.00 +"s");
                //dosth. 3s
                Thread.sleep(3000);
                System.out.println("文件处理时间： " +3 +"s");

            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        finally {
        }
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " +(endTime-startTime)/1000.00 +"s");
    }

    public static void main(String[] args) {
         String FileArr[]=new String[3];
         FileArr[0] ="D:\\download\\VMware-workstation-full-12.5.7-5813279.exe";
         FileArr[1] ="D:\\download\\mysql-8.0.11-winx64.zip";
         FileArr[2] ="D:\\download\\ue_chinese_24.20.0.62.exe";
         //new MyThread().readIO(FileArr);
           new MyThread().doThread(FileArr);
    }


    public void doThread( String []fileArr){
        for(int i=0;i<fileArr.length ;i++){
            new Thread(new ThreadRun(fileArr[i])).start();
        }
    }

    /**
     * Note:
     *   FileInputStream 5 s
     *   BufferedReader 10 s
     *   BufferedInputStream 7 s
     *   BufferedReader 明显比 FileInputStream 慢
     * @param: 
     * @return:
     * @auther: qiugy
     * @date: 2018/6/8 9:25
     */
}
