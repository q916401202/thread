package com.qing.thread02.test;

import java.util.Random;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/18 下午 04:33
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Indicator.getInstance().newRequestReceive();
                    int i1 = new Random().nextInt();
                    if (i1 % 2 == 0) {
                        Indicator.getInstance().newRequestSuccess();
                    } else {
                        Indicator.getInstance().newRequestFailure();
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(Indicator.getInstance().getRequestCount());
        System.out.println(Indicator.getInstance().getSuccessCount());
        System.out.println(Indicator.getInstance().getFailureCount());
    }

}
