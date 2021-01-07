package com.qing.thread01.thread11;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:26
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i=0;i<1000;i++){
            System.out.println("main "+i);
        }
        Thread.currentThread().interrupt();
    }
}
