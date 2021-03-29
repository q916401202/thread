package com.qing.thread02.test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/18 下午 05:02
 */
public class Test03 {
    static AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(10);
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i=0;i<threads.length;i++){
            threads[i] = new AddThread();
        }
        for (Thread thread : threads) {
            thread.start();
            System.out.println(atomicIntegerArray);
        }
        for (Thread thread : threads) {
            thread.join();

        }

        System.out.println(atomicIntegerArray);
        new Thread(new AddThread()).start();
        Thread.sleep(5000);
        System.out.println(atomicIntegerArray);


    }
    static class AddThread extends Thread{
        @Override
        public void run() {

           for (int i=0;i<10000;i++){
               atomicIntegerArray.getAndIncrement(i%atomicIntegerArray.length());
           }
        }
    }

}
