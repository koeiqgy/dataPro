package com.koei.test.thread;

/**
 * @Auther: paul
 * @Date: 2018/6/8 15:13
 * @Description:
 */
public class Thread3 {
    public static void main(String[] args) {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName);
        for (   int  i = 0; i < 10; i++) {
            new Thread("" +i){
                @Override
                public void run() {
                    //super.run();
                    System.out.println("Thread: " + getName());
                }
            }.start();
        }
    }
}
