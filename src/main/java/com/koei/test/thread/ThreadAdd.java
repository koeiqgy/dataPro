package com.koei.test.thread;

/**
 * @Auther: paul
 * @Date: 2018/6/8 16:11
 * @Description:
 */
public class ThreadAdd {
    private int count=0;
    
    /**
     * 功能描述: 
     * 此方法是临界区 多线程下容易错乱
     * @param:
     * @return: 
     * @auther: qiugy
     * @date: 2018/6/8 16:50
     */
    public void addCount(int num){
        this.count=this.count+num;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}