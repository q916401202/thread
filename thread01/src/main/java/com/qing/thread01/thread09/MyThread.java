package com.qing.thread01.thread09;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:14
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        Long time=System.currentTimeMillis();

        int sum=0;
        for (int i=1;i<10000000;i++){
            sum=sum+i;
            //线程让步
            Thread.yield();
        }



        System.out.println("run用时   "+(System.currentTimeMillis()-time));

    }
}
