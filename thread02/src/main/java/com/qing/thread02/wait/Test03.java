package com.qing.thread02.wait;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/19 下午 12:14
 */
public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        String lock = "wkcto";
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程1开始等待" + System.currentTimeMillis());
                    try {
                        //线程等待，会释放锁对象，当前线程转入blocked阻塞状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1结束等待" + System.currentTimeMillis());
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程2开始唤醒" + System.currentTimeMillis());
                    //唤醒lock锁对象上等待的某一个线程，当前线程执行完才会唤醒
                    lock.notify();
                    System.out.println("线程2结束唤醒" + System.currentTimeMillis());
                }
            }
        });

        t1.start();
        Thread.sleep(3000);
        t2.start();


    }
}
