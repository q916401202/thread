package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test09 {
    public static void main(String[] args) {
        Test09 test01 = new Test09();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Test09.mm2();
            }
        }).start();


    }

    public void mm() {
        synchronized (Test09.class) {
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName() + "------->" + i);
                if (i==50){
                    System.out.println(1/0);
                }
            }
        }
    }


    public synchronized static void mm2() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "------->" + i);
        }
    }

//使用当前类作为锁，锁生效
}
