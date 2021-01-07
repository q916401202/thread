package com.qing.thread01.thread04;

import javax.security.auth.Subject;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/7 下午 04:25
 */
public class MyThread extends Thread{
    public MyThread(){
        System.out.println("构造方法打印线程名称"+Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("打印当前线程名称"+Thread.currentThread().getName());
    }
}
