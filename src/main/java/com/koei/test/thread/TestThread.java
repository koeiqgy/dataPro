package com.koei.test.thread;

/**
 * @Auther: paul
 * @Date: 2018/6/6 11:12
 * @Description:
 */

class T1 extends Thread{
     private String name;
     int times=0;
    public T1(String name) {
        this.name = name;
        System.out.println("--------name--------");
    }

    public T1(String name,int times) {
        this.times = times;
        this.name= name;
    }

    @Override
    public void run() {
        for (int i = 1; i <=times; i++) {
            System.out.println(name+" "+i);
        }
        //super.run();
    }
}

public class TestThread {
    public static void main(String args[]){
            T1 t1=new T1("mama",10);
            T1 t2=new T1("baba",15);
            T1 t3=new T1("me",5);
            t1.start();
            t2.start();
            t3.start();
    }
}
