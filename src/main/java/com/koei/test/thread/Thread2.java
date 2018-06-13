package com.koei.test.thread;

/**
 * @Auther: paul
 * @Date: 2018/6/6 13:24
 * @Description:
 */


/**
 * 功能描述: 
 *
 * @param: 
 * @return: 
 * @auther: qiugy
 * @date: 2018/6/6 13:51
 */


class ThreadCat  implements  Runnable{
    private String name;
    public ThreadCat(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " "+i);
        }   
    }
}

public class Thread2{

    public static void main(String[] args) {
        new Thread(new ThreadCat("A")).start();
        new Thread(new ThreadCat("B")).start();
    }
}