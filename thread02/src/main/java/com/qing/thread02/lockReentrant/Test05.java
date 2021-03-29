package com.qing.thread02.lockReentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test05 {
    static class SubThread extends Thread {
        static Lock lock = new ReentrantLock();
        public static int num = 0;

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                try {
                    lock.lock();
                    lock.lock();
                    num++;

                }finally {
                    lock.unlock();
                    lock.unlock();
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SubThread subThread1 = new SubThread();
        SubThread subThread2 = new SubThread();
        SubThread subThread3 = new SubThread();
        SubThread subThread4 = new SubThread();
        SubThread subThread5 = new SubThread();
        subThread1.start();
        subThread2.start();
        subThread3.start();
        subThread4.start();
        subThread5.start();
        subThread1.join();
        subThread2.join();
        subThread3.join();
        subThread4.join();
        subThread5.join();
        System.out.println(SubThread.num);
    }


}
