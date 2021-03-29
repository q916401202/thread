package com.qing.thread02.lockReentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test06 {
    static class Service {
        private Lock lock = new ReentrantLock();

        public void serviceMethod() {
            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "   begin lock");
                for (int i = 0; i < 1000; i++) {
                    System.out.println("=================="+i);
                }
                System.out.println(Thread.currentThread().getName() + "    end lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "   释放锁");
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                service.serviceMethod();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(1);
        Thread t2 = new Thread(runnable);
        t2.start();
        Thread.sleep(1);
        t2.interrupt();

    }


}
