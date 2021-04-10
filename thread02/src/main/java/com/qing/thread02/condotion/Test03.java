package com.qing.thread02.condotion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qing
 * @version 1.0
 * @date 2021/3/29 下午 10:22
 */
public class Test03 {

    static class MyService{
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();
        private boolean flag=true;
        public void printOne(){
            try {
                lock.lock();
                while (flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"----------------------");
                flag=true;
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
               lock.unlock();
            }
        }
        public void printTwo(){
            try {
                lock.lock();
                while (!flag){
                    condition.await();
                }
                System.out.println(Thread.currentThread().getName()+"  ******************** ");
                flag=false;
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
               lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        MyService myService = new MyService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    myService.printOne();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    myService.printTwo();
                }
            }
        }).start();
    }


}
//测试一
//测试二
//测试三