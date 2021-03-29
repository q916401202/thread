package com.qing.thread02.wait;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        SubThread subThread = new SubThread();
        subThread.start();
        //确保子线程处于等待状态
        Thread.sleep(2000);
        //中断线程
        subThread.interrupt();


//        中断线程，会唤醒线程等待

    }
    private static final Object LOCK=new Object();
    static class SubThread extends Thread{
        @Override
        public void run() {
            synchronized (LOCK){
                try {
                    System.out.println("begin wait...");
                    LOCK.wait();
                    System.out.println("end wait...");
                }catch (Exception e){
                    System.out.println("wait等待被中断了...");
                    e.printStackTrace();
                }

            }
        }
    }
}
