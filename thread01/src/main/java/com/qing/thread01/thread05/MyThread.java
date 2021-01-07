package com.qing.thread01.thread05;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:30
 */
public class MyThread extends Thread{
    public MyThread(){
        System.out.println("构造方法"+Thread.currentThread().getName());
        System.out.println("构造方法"+this.getName());
    }
    @Override
    public void run() {
        System.out.println("run方法"+Thread.currentThread().getName());
        System.out.println("run方法"+this.getName());

    }
}
