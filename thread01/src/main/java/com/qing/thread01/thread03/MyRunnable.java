package com.qing.thread01.thread03;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:16
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("runnable  "+i);
        }
    }
}
