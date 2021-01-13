package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/13 上午 11:43
 */
public class Test10 {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.setName("a");
        subThread.start();

        SubThread subThread1 = new SubThread();
        subThread1.setName("b");
        subThread1.start();
    }

    static class SubThread extends Thread{
        private static final Object lock1=new Object();
        private static final Object lock2=new Object();
        @Override
        public void run() {
            if ("a".equals(Thread.currentThread().getName())){
                synchronized (lock1){
                    System.out.println("a线程获取到了lock1锁，还需要获取lock2锁");
                    synchronized (lock2){
                        System.out.println("a线程获取了lock2锁，可以想干想干的事");
                    }
                }
            }
            if ("b".equals(Thread.currentThread().getName())){
                synchronized (lock2){
                    System.out.println("b线程获取到了lock2锁，还需要获取lock1锁");
                    synchronized (lock1){
                        System.out.println("b线程获取了lock1锁，可以想干想干的事");
                    }
                }
            }
        }
    }

}
