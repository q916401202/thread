package com.qing.thread02.lockReentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Test10 {
    static class IntLock implements Runnable {
        private static ReentrantLock lock1 = new ReentrantLock();
        private static ReentrantLock lock2 = new ReentrantLock();
        private int lockNum;

        public IntLock(int lockNum) {
            this.lockNum = lockNum;
        }

        @Override
        public void run() {
            try {
                if (lockNum % 2 == 0) {
                    while (true) {
                        try {
                            if (lock1.tryLock()) {
                                System.out.println(Thread.currentThread().getName() + "   获得锁1，还想获得锁2");
                                Thread.sleep(100);
                                try {
                                    if (lock2.tryLock()) {
                                        System.out.println(Thread.currentThread().getName() + "   同时获得锁1与锁2  -----完成任务");
                                        return;
                                    }
                                } finally {
                                    if (lock2.isHeldByCurrentThread()) {
                                        lock2.unlock();
                                    }
                                }

                            }
                        } finally {
                            if (lock1.isHeldByCurrentThread()) {
                                lock1.unlock();
                            }
                        }

                    }
                } else {
                    while (true) {
                        try {
                            if (lock2.tryLock()) {
                                System.out.println(Thread.currentThread().getName() + "   获得锁2，还想获得锁1");
                                Thread.sleep(100);
                                try {
                                    if (lock1.tryLock()) {
                                        System.out.println(Thread.currentThread().getName() + "   同时获得锁2与锁1  -----完成任务");
                                        return;
                                    }
                                } finally {
                                    if (lock1.isHeldByCurrentThread()) {
                                        lock1.unlock();
                                    }
                                }

                            }
                        } finally {
                            if (lock2.isHeldByCurrentThread()) {
                                lock2.unlock();
                            }
                        }
                    }


                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) {
        IntLock i1 = new IntLock(11);
        IntLock i2 = new IntLock(22);

        new Thread(i1).start();
        new Thread(i2).start();

    }


}
