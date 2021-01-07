package com.qing.thread01.thread07;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:47
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run01  "+ Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(2000);

            System.out.println("run02 "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
