package com.qing.thread01.thread05;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:32
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.setName("线程名称");
        myThread.start();
        Thread.sleep(500);

        Thread thread = new Thread(myThread);
        thread.start();


    }
}
