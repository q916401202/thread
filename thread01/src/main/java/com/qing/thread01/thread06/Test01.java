package com.qing.thread01.thread06;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:42
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("线程  "+ myThread.isAlive());
        myThread.start();
        System.out.println("线程01  "+ myThread.isAlive());
    }
}
