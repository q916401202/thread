package com.qing.thread02.lockReentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test04 {
    static Lock lock = new ReentrantLock();

    public static void sm1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "   method  11   " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "   method  11   " + System.currentTimeMillis());
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void sm2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "   method  22   " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "   method  22   " + System.currentTimeMillis());
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sm1();
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                sm2();
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable1).start();
        new Thread(runnable1).start();
        new Thread(runnable1).start();

    }

}
