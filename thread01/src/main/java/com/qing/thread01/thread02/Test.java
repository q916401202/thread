package com.qing.thread01.thread02;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:12
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();


        for (int i=0;i<10;i++){
            System.out.println("当前线程  "+i);
            int i1 = (int) Math.random() * 1000;
            try {
                Thread.sleep(i1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
