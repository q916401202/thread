package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/12 下午 05:01
 */
public class Test03 {
    public static void main(String[] args) {
        Test03 test01 = new Test03();
        Test03 test02 = new Test03();
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
private static final Object object=new Object();
    public void mm(){
        synchronized (object){
        for (int i=1;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
        }
    }


    //常量锁


}
