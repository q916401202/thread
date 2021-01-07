package com.qing.thread01.thread08;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:07
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run "+Thread.currentThread().getName()+"   "+Thread.currentThread().getId());
//        System.out.println("run "+Thread.currentThread().getName()+"   "+this.getId());
    }
}
