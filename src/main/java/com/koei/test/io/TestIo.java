package com.koei.test.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: paul
 * @Date: 2018/6/6 15:03
 * @Description:
 */
public class TestIo {
    private static String path="d:\\SSTA\\副本.txt";
    private static String outPath="d:\\SSTA\\副本1508.txt";

    public static void main(String[] args) {
        FileInputStream fins=null;
        FileOutputStream fout=null;
        try {
            byte[] bytes=new byte[1024];
            int len=0;
            fins=new FileInputStream(path);
            fout=new FileOutputStream(outPath);
            while((len=fins.read(bytes,0,bytes.length))!=-1){
                fout.write(bytes,0,len);
                fout.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fins.close();
                fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
