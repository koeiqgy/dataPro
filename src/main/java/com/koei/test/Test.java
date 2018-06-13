package com.koei.test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * @Auther: paul
 * @Date: 2018/6/1 10:23
 * @Description:
 */
public class Test {

    public static void main1(String[] args) {
        try {

            Constructor<File> constructor = File.class.getDeclaredConstructor(String.class);
            //获得File类的Constructor对象

            System.out.println("Create File Object with reflection.");
            //使用反射创建File对象
            File file = constructor.newInstance("D:\\SSTA\\tool\\6.txt");
            System.out.println("Use File Object to create MyFile.txt on desktop.");
            //指定了创建的路径为桌面，名称为“MyFile.txt”

            file.createNewFile(); //创建新的文件
            System.out.println("File is created ?" + file.exists());
            //验证文件是否创建成功

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            ArrayList<String> list=  ArrayList.class.newInstance();
            list.add("paul");
            list.add("tom");
            list.add("mickey");
            for(String s:list){
                System.out.println(s);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {

        }
    }

}
