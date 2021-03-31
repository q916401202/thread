package com.qing.thread02.readWrite;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test01 {
    static class Service{
        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        public void read(){
            try {
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName()+" 获得读锁，开始读取数据的时间--"+System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(3);

            }catch (Exception e){
                e.printStackTrace();

            }finally {
                readWriteLock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.read();
                }
            }).start();
        }


    }



}
