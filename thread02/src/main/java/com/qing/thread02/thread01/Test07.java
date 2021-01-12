package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:55
 */
public class Test07 {
    public static void main(String[] args) {
        Test07 test07 = new Test07();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test07.doLongTimeTask();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test07.doLongTimeTask();
            }
        }).start();


    }

    public synchronized void doLongTimeTask(){
        System.out.println("Task 开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        synchronized (this){
            System.out.println("开始同步");
            for (int i=1;i<=20;i++){
                System.out.println(Thread.currentThread().getName()+"------------->"+i);
            }
//        }
        System.out.println("task 结束");

    }
}
