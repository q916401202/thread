package com.qing.thread02.wait;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/19 下午 12:06
 */
public class Test01 {
    public static void main(String[] args) {
        try {
            String test="wkcto";
            test.wait();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
