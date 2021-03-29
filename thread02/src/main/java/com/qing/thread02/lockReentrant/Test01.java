package com.qing.thread02.lockReentrant;

public class Test01 {

    public synchronized void sm1(){
        System.out.println("同步方法1");
        sm2();
    }
    public synchronized void sm2(){
        System.out.println("同步方法2");
        sm3();
    }
    public synchronized void sm3(){
        System.out.println("同步方法3");
    }


    public static void main(String[] args) {
        Test01 test01 = new Test01();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test01.sm1();
            }
        }).start();

    }
}
