package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test04 {
    public static void main(String[] args) {
        Test04 test01 = new Test04();
        Test04 test02 = new Test04();
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                mm01();
            }
        }).start();


    }
private static final Object object=new Object();

    public void mm(){
        synchronized (object){
        for (int i=1;i<=20;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
        }
    }

    public static void mm01(){
        synchronized (object){
            for (int i=1;i<=20;i++){
                System.out.println(Thread.currentThread().getName()+"------->"+i);
            }
        }
    }
//常量锁在不同方法都会生效
}
