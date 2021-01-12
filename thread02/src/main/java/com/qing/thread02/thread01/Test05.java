package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test05 {
    public static void main(String[] args) {
        Test05 test01 = new Test05();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm2();
            }
        }).start();


    }

    public void mm(){
        synchronized (this){
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
        }
    }

    //默认this作为锁对象
    public synchronized void mm2(){
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
    }

//对象锁，这种情况锁生效
}
