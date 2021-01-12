package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test02 {
    public static void main(String[] args) {
        Test02 test01 = new Test02();
        Test02 test02 = new Test02();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test02.mm();
            }
        }).start();


    }

    public void mm(){
        synchronized (this){
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
        }
    }

//不同对象调用方法，这种情况锁失效
}
