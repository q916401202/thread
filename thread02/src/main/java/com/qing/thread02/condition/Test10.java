package com.qing.thread02.condition;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test10 {

    static ReentrantLock lock= new ReentrantLock();

    static Condition condition=lock.newCondition();
    static void sm(){
        try {
            lock.lock();
            System.out.println("是否有线程正在等待当前Condition条件？ "+lock.hasWaiters(condition)+"  ---waitqueuelenth: "+lock.getWaitQueueLength(condition));
            System.out.println(Thread.currentThread().getName()+"  lock...");
            condition.await(new Random().nextInt(1000), TimeUnit.MILLISECONDS);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"   超时唤醒，是否有线程正在等待当前Condition条件？ "+lock.hasWaiters(condition)+"  ---waitqueuelenth: "+lock.getWaitQueueLength(condition));
//            System.out.println(Thread.currentThread().getName()+"  unlock...");
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
