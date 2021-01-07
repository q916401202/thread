package com.qing.thread01.thread06;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:41
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run方法  "+this.isAlive());
    }
}
