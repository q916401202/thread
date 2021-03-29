package com.qing.thread02.wait;

public class Test04 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        System.out.println("begin wait...");
                        lock.wait();
                        System.out.println("wait end...");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
                synchronized (lock) {
                    System.out.println("begin notify");
                    lock.notify();
                    System.out.println("end nofity");
                }

//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }
        });
        thread.start();
        thread1.start();
    }
}
