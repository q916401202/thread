package com.qing.thread02.wait;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/19 下午 12:07
 */
public class Test02 {
    public static void main(String[] args) {
        try {
            String text="wkcto";
            String another="hello";
            System.out.println("同步前的代码");
            synchronized (text){
                System.out.println("同步代码块开始。。。。");
                //调用wait当前线程处于等待，释放锁，需要唤醒，不唤醒会一直等待下去
                text.wait();
                System.out.println("wait后面的代码");
            }
            System.out.println("同步代码块后面的代码");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("main后面的代码");
    }
}
