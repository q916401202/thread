package com.qing.thread02.threadGroup;

public class Test04 {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程---"+Thread.currentThread()+"  --开始循环");
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName()+"  --------------");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
                System.out.println(Thread.currentThread().getName()+"   循环结束");
            }
        };

        ThreadGroup group = new ThreadGroup("group");
        for (int i=0;i<5;i++){
            new Thread(group,runnable).start();
        }
        Thread.sleep(2);

        group.interrupt();

    }


}
