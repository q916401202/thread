package com.qing.thread02.condotion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qing
 * @version 1.0
 * @date 2021/3/29 下午 10:05
 */
public class Test02 {
    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();

        public void waitMethodA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "  begin wait " + System.currentTimeMillis());
                conditionA.await();
                System.out.println(Thread.currentThread().getName() + "  end wait " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                lock.unlock();
                System.out.println("A============");
            }

        }

        public void waitMethodB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "  begin wait " + System.currentTimeMillis());
                conditionB.await();
                System.out.println(Thread.currentThread().getName() + "  end wait " + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println("b==========");
            }

        }

        public void signalA() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "signal A time =" + System.currentTimeMillis());
                conditionA.signal();
                System.out.println(Thread.currentThread().getName() + "signal A time =" + System.currentTimeMillis());
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }

        public void signalB() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "signal B time =" + System.currentTimeMillis());
                conditionB.signal();
                System.out.println(Thread.currentThread().getName() + "signal B time =" + System.currentTimeMillis());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodA();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethodB();
            }
        }).start();
        Thread.sleep(3000);

        service.signalA();
        service.signalB();

    }


}
