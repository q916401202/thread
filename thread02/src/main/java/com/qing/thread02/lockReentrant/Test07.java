package com.qing.thread02.lockReentrant;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test07 {

    static class IntLock implements Runnable {
        public static ReentrantLock lock1 = new ReentrantLock();
        public static ReentrantLock lock2 = new ReentrantLock();
        int lockNum;

        public IntLock(int lockNum) {
            this.lockNum = lockNum;
        }

        @Override
        public void run() {
            try {

                if (lockNum % 2 == 0) {
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "  获得锁1，还需要获得锁2");
                    Thread.sleep(new Random().nextInt(500));
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "   同时获得了锁1与锁2");
                } else {
                    lock2.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "  获得锁2，还需要获得锁1");
                    Thread.sleep(new Random().nextInt(500));
                    lock1.lockInterruptibly();
                    System.out.println(Thread.currentThread().getName() + "   同时获得了锁2与锁1");
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()){
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()){
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "   线程退出了");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        IntLock intLock1 = new IntLock(11);
        IntLock intLock2 = new IntLock(22);
        Thread t1 = new Thread(intLock1);
        Thread t2 = new Thread(intLock2);
        t1.start();
        t2.start();
        Thread.sleep(3000);
        if (t1.isAlive()){
            t1.interrupt();
        }
//        if (t2.isAlive()){
//            t2.interrupt();
//        }
    }


}
