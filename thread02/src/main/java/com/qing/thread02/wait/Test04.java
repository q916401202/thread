package com.qing.thread02.wait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/19 下午 12:23
 */
public class Test04 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Runnable target;
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (list){
                    if (list.size()!=5){
                        System.out.println("c ");
                    }
                }
            }
        });

    }
}
