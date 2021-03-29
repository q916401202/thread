package com.qing.thread02.wait;

public class Test03 {
    public static void main(String[] args) {
        Object o = new Object();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    try {
                        System.out.println("thread begin wait");
                        //如果5秒内没有唤醒会自动唤醒
                        o.wait(5000);
                        System.out.println("end wait..");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();
    }


    static class SubThread extends Thread {

    }

}
