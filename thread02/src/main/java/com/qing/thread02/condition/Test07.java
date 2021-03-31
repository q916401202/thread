package com.qing.thread02.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Test07 {
    static ReentrantLock lock=new ReentrantLock();
    public static void sm(){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"   获得锁，执行方法，估计等待获得锁的线程数   "+ lock.getQueueLength());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                sm();
            }
        };
        for (int i=0;i<10;i++){
            new Thread(runnable).start();
        }

    }

}
