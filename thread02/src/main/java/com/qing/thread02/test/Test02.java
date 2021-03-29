package com.qing.thread02.test;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/18 下午 04:50
 */
public class Test02 {
    public static void main(String[] args) {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.get(0));
        System.out.println(atomicIntegerArray.get(1));


        atomicIntegerArray.set(0,10);

        //设置数组新值，返回旧值
        System.out.println(atomicIntegerArray.getAndSet(1,11));

        System.out.println(atomicIntegerArray);

        //先加在返回值
        System.out.println(atomicIntegerArray.addAndGet(0,22));

        //先返回在加值
        System.out.println(atomicIntegerArray.getAndAdd(1,33));

        //如果数组中索引为0的值为32，就修改为22
        System.out.println(atomicIntegerArray.compareAndSet(0,32,222));

        System.out.println(atomicIntegerArray);

        System.out.println(atomicIntegerArray.compareAndSet(1,321,222));

        System.out.println(atomicIntegerArray);

        //先自增加1在返回
        System.out.println(atomicIntegerArray.incrementAndGet(0));

        //先返回在自增加1
        System.out.println(atomicIntegerArray.getAndIncrement(1));

        System.out.println(atomicIntegerArray);

        //先减一在返回
        System.out.println(atomicIntegerArray.decrementAndGet(2));
        System.out.println(atomicIntegerArray);

        //先返回在减一
        System.out.println(atomicIntegerArray.getAndDecrement(3));
        System.out.println(atomicIntegerArray);


    }
}
