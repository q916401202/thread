package com.qing.thread02.condition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test11 {


    static class Service{
        ReentrantLock lock;

        public Service(boolean isFair){
            this.lock=new ReentrantLock(isFair);
        }

        public void serviceMethod(){
            try {
                System.out.println("是否为公平锁"+lock.isFair()+"   "+Thread.currentThread().getName()+"调用lock前是否持有锁？  "+lock.isHeldByCurrentThread());
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" 调用lock方法后是否持有锁"+lock.isHeldByCurrentThread());

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }



    }




    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int num=new Random().nextInt();
                new Service(num % 2 == 0 ? true : false).serviceMethod();
            }
        };

        for (int i=0;i<3;i++){
            new Thread(runnable,"thread-"+i).start();
        }


    }
}
