package com.qing.thread02.wait;

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        SubThread t1 = new SubThread(o);
        SubThread t2 = new SubThread(o);
        SubThread t3 = new SubThread(o);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(2000);

        synchronized (o) {
            //随机唤醒一个线程
//            o.notify();
            //唤醒全部得线程
            o.notifyAll();
        }
    }

    static class SubThread extends Thread {
        private Object lock;

        public SubThread(Object lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + "....begin  wait....");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + "----end wait...");
                } catch (Exception e) {
                    System.out.println();
                    e.printStackTrace();
                }
            }
        }
    }
}
