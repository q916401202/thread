package com.qing.thread01.thread12;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:37
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        for (int i =1;i<100000;i++){
            System.out.println("main  "+i);
        }
    }
}
