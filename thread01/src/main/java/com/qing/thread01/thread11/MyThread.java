package com.qing.thread01.thread11;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:26
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("run "+i);
        }

    }
}
