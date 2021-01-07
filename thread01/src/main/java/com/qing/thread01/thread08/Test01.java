package com.qing.thread01.thread08;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 05:08
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println("main  "+Thread.currentThread().getId());

        for (int i=0;i<100;i++){
            new MyThread().start();
        }
    }
}
