package com.qing.thread02.lockReentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Test09 {

    static class Service{
        private ReentrantLock lock=new ReentrantLock();
        public void serviceMethod(){
            try {
                if (lock.tryLock()){
                    System.out.println(Thread.currentThread().getName()+"   获得锁");
                    Thread.sleep(3000);
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




    public static void main(String[] args) throws InterruptedException {
        Service s1 = new Service();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                s1.serviceMethod();
            }
        };
        Thread t1 = new Thread(runnable);
        t1.start();
        Thread.sleep(50);
        Thread t2 = new Thread(runnable);
        t2.start();
    }



}
