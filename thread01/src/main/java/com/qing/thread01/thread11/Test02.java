package com.qing.thread01.thread11;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:26
 */
public class Test02 {
    public static void main(String[] args) {
        MyThread02 myThread = new MyThread02();
        myThread.start();
        for (int i=0;i<1000;i++){
            System.out.println("main "+i);
        }
        myThread.interrupt();
    }
}
