package com.qing.thread01.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:03
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("测试执行顺序");
    }
}
