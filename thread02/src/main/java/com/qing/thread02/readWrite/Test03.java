package com.qing.thread02.readWrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test03 {
static class Service{
     ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
     public void write(){
         try {
             readWriteLock.writeLock().lock();
             System.out.println(Thread.currentThread().getName()+"   获得写锁，开始修改数据的时间--"+System.currentTimeMillis());
             Thread.sleep(3000);
         }catch (Exception e){
             e.printStackTrace();

         }finally {
             System.out.println(Thread.currentThread().getName()+"  修改数据完毕时的时间=="+System.currentTimeMillis());
             readWriteLock.writeLock().unlock();

         }
     }
     public void read(){
         try {
             readWriteLock.readLock().lock();
             System.out.println(Thread.currentThread().getName()+"   获得读锁，开始修改数据的时间--"+System.currentTimeMillis());
             Thread.sleep(3000);
         }catch (Exception e){
             e.printStackTrace();

         }finally {
             System.out.println(Thread.currentThread().getName()+"  读取数据完毕时的时间=="+System.currentTimeMillis());
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

       for (int i=0;i<5;i++){
           new Thread(new Runnable() {
               @Override
               public void run() {
                   service.write();
               }
           }).start();
       }


    }

}
