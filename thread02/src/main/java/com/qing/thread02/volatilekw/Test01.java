package com.qing.thread02.volatilekw;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/3 下午 03:13
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        printString.printStringMethod();
        Thread.sleep(1000);
        System.out.println("在main线程修改标准");
        printString.setContinuePrint(false);
        //printStringMethod一直处于死循环状态，程序不执行 printString.setContinuePrint(false);


    }
    static class PrintString{
        private boolean continuePrint=true;
        public PrintString setContinuePrint(boolean continuePrint){
            this.continuePrint=continuePrint;
            return this;
        }
        public void printStringMethod(){
            while (continuePrint){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
