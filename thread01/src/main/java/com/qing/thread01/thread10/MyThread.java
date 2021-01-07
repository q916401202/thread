package com.qing.thread01.thread10;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:20
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        int sum=0;
        for (int i=0;i<10000;i++){
            sum=sum+1;
        }

        System.out.println("run优先级"+Thread.currentThread().getPriority());
    }
}
