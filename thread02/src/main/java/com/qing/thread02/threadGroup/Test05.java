package com.qing.thread02.threadGroup;

public class Test05 {


    public static void main(String[] args) throws InterruptedException {

        ThreadGroup group = new ThreadGroup("group");
        group.setDaemon(true);
        for (int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<20;j++){
                        System.out.println(Thread.currentThread().getName()+"   ------    "+j);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        Thread.sleep(5000);
        System.out.println("main ...end ...");


    }

}
