package com.utils;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * @Auther: paul
 * @Date: 2018/8/2 11:03
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
/*        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){}

        System.out.println(System.getProperty("user.dir"));//user.dir指定了当前的路径

        //String class_path=Class.class.getClass().getResource("/").getPath();
        File f = new File(Test.class.getClass().getResource("/").getPath());

        System.out.println(f);*/
        try {
            File file = ResourceUtils.getFile("classpath:private_key");
            File file2 = ResourceUtils.getFile("classpath:public_key");


            System.out.println(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
