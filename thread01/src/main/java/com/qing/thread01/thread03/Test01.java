package com.qing.thread01.thread03;

import com.qing.thread01.thread02.MyThread;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:16
 */
public class Test01 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        for (int i=0;i<100;i++){
            System.out.println("main   "+i);
        }
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
