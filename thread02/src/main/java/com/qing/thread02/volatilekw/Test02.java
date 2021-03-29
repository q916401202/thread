package com.qing.thread02.volatilekw;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/3 下午 03:13
 */
public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(new Runnable() {
            @Override
            public void run() {
                printString.printStringMethod();
            }
        }).start();


        Thread.sleep(1000);
        System.out.println("在main线程修改标准");
        printString.setContinuePrint(false);

//        volatile强制线程从公共内存中读取变量得值


    }

    static class PrintString {
        private volatile boolean continuePrint = true;

        public PrintString setContinuePrint(boolean continuePrint) {
            this.continuePrint = continuePrint;
            return this;
        }

        public void printStringMethod() {
            System.out.println("开始执行");
            while (continuePrint) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("结束执行");
        }

    }
}
