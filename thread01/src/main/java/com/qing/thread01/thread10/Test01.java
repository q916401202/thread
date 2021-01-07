package com.qing.thread01.thread10;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:20
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setPriority(10);
        myThread.start();




    }
}
