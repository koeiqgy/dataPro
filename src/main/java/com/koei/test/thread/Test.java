package com.koei.test.thread;

/**
 * @Auther: paul
 * @Date: 2018/6/8 16:15
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ThreadAdd add=new ThreadAdd();
        int a=2;
        int b=3;
        for(int i=0;i<100;i++){
            new Thread(){
                @Override
                public void run() {
                    add.addCount(a);
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    add.addCount(b);
                }
            }.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
            int count=add.getCount();
            if(count!=a+b){
                System.out.println(count);
            }
            add.setCount(0);
        System.out.println("----------------------------------------------");
        }
    }
}
