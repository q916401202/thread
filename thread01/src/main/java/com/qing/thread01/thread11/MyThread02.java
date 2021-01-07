package com.qing.thread01.thread11;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:26
 */
public class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            if (this.isInterrupted()){
                System.out.println("当前线程的中断为true，要退出");
                break;
            }
            System.out.println("run "+i);
        }

    }
}
