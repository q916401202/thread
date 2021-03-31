package com.qing.thread02.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Test05 {
    static ReentrantLock lock=new ReentrantLock();
    static ReentrantLock lock02=new ReentrantLock(true);


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock02.lock();
                        System.out.println(Thread.currentThread().getName() + "  获得了锁对象");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock02.unlock();
                    }
                }
            }
        };

        for (int i=0;i<5;i++){
            new Thread(runnable).start();
        }

    }


}
