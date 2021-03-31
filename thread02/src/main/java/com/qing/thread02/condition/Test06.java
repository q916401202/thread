package com.qing.thread02.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Test06 {
    static ReentrantLock lock = new ReentrantLock();

    public static void m1(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"   m1-- hold count :"+lock.getHoldCount());
            m2();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public static void m2(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"   m2-- hold count :"+lock.getHoldCount());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m1();
    }


}
