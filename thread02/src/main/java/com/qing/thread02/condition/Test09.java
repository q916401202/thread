package com.qing.thread02.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Test09 {
    static ReentrantLock lock=new ReentrantLock();
    public static void waitMethod(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"  获得了锁");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"   释放了锁对象");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                waitMethod();
            }
        };
        Thread[] threads = new Thread[5];
        for (int i=0;i<threads.length;i++){
            threads[i]=new Thread(runnable);
            threads[i].setName("thread - "+i);
            threads[i].start();
        }
        Thread.sleep(3000);
        System.out.println(lock.hasQueuedThread(threads[0]));
        System.out.println(lock.hasQueuedThread(threads[1]));
        System.out.println(lock.hasQueuedThread(threads[2]));
        System.out.println(lock.hasQueuedThread(threads[3]));
        System.out.println(lock.hasQueuedThread(threads[4]));
        Thread.sleep(2000);
        System.out.println(lock.hasQueuedThreads());
    }
}
