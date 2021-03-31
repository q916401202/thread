package com.qing.thread02.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test08 {
    static class Service{
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void waitMethod(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"  进入等待前，现在该cindtion条件上等待的线程预估数： "+lock.getWaitQueueLength(condition));
            condition.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void notifyMethod(){
        try {
            lock.lock();
            condition.signalAll();
            System.out.println(Thread.currentThread().getName()+" 唤醒所有的等待后，condtion条件上等待的线程预估数："+lock.getWaitQueueLength(condition));
        }finally {
            lock.unlock();
        }
    }
    }


    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                service.waitMethod();
            }
        };
        for (int i=0;i<10;i++){
            new Thread(runnable).start();
        }
        Thread.sleep(1000);
        service.notifyMethod();
    }
}
