package com.qing.thread02.condotion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qing
 * @version 1.0
 * @date 2021/3/29 下午 09:58
 */
public class Test01 {

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static class SubThread extends Thread {
        @Override
        public void run() {

            try {
                lock.lock();
                System.out.println("method lock");
                condition.await();
                System.out.println("method await");


            } catch (Exception e) {

            } finally {
                lock.unlock();
                System.out.println("method unlock");

            }


        }
    }

    public static void main(String[] args) throws InterruptedException {
        SubThread subThread = new SubThread();
        subThread.start();
        Thread.sleep(3000);

        try {
            lock.lock();
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
