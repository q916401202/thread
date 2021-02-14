package com.qing.thread02.volatilekw;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/3 下午 04:04
 */
public class Test03 {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new MyThread().start();
        }

    }
    static class MyThread extends Thread{

//        volatile表示所有线程从主内存读取count变量得值
        volatile public static int count;
        public synchronized static void addCount(){
            for (int i=0;i<1000;i++){
                count++;
            }
            System.out.println(Thread.currentThread().getName()+"count"+count);
        }

        @Override
        public void run() {
            addCount();
        }
    }
}
