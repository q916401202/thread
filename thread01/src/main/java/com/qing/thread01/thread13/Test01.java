package com.qing.thread01.thread13;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/11 上午 10:53
 */
public class Test01 {
    public static void main(String[] args) {
        MyInt01 myInt = new MyInt01();
        for (int i=0;i<8;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(Thread.currentThread().getName()+"——》"+myInt.getNum());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }

    static class MyInt{
        int num;
        public int getNum(){
            return num++;
        }
    }

    static class MyInt01{
        AtomicInteger num=new AtomicInteger();

        public int getNum(){
            return num.getAndIncrement();
        }
    }
}
