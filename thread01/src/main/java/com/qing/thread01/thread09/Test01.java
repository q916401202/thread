package com.qing.thread01.thread09;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:14
 */
public class Test01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();



        Long time=System.currentTimeMillis();
        int sum=0;
        for (int i=1;i<10000000;i++){
            sum=sum+i;
        }
        System.out.println("main用时   "+(System.currentTimeMillis()-time));
    }
}
