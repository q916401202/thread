package com.qing.thread02.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Test12 {

    static ReentrantLock lock= new ReentrantLock();
    static void sm(){
        try {
            System.out.println("before lock()--"+lock.isLocked());
            lock.lock();
            System.out.println("after lock()--"+lock.isLocked());
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("11  --- "+lock.isLocked());
        new Thread(new Runnable() {
            @Override
            public void run() {
                sm();
            }
        }).start();
        Thread.sleep(3000);

        System.out.println("22  ---- "+lock.isLocked());





    }



}
