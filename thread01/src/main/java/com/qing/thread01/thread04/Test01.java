package com.qing.thread01.thread04;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:27
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("主线程打印线程名称"+Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
