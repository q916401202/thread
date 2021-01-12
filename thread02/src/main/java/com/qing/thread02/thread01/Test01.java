package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test01 {
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.mm();
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


    //this锁

}
