package com.qing.thread02.lockReentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test08 {

    static class TimLock implements Runnable{
        private static ReentrantLock lock =new ReentrantLock();

        @Override
        public void run() {
            try {
                if (lock.tryLock(3, TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName()+"  获得锁，执行耗时任务");
                    Thread.sleep(4000);
                }else {
                    System.out.println(Thread.currentThread().getName()+"   没有获得锁");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }

        }
    }
    public static void main(String[] args) {
        TimLock timLock = new TimLock();
        Thread t1 = new Thread(timLock);
        Thread t2 = new Thread(timLock);
        t1.start();
        t2.start();
    }


}
