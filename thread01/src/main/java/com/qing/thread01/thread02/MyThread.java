package com.qing.thread01.thread02;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:12
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("线程  "+i);
            int i1 = (int) Math.random() * 1000;
            try {
                Thread.sleep(i1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
