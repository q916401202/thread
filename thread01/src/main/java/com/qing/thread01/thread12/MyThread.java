package com.qing.thread01.thread12;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:37
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("run..............");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
