package com.qing.thread02.produerstack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    private List list=new ArrayList();
    private static final int MAX=1;

    //定义方法模拟入栈
    public synchronized void push(){
        while (list.size()>MAX){
            System.out.println(Thread.currentThread().getName()+"push   begin wait...");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String data="data--"+Math.random();
        System.out.println(Thread.currentThread().getName()+"添加了数据："+data);
        list.add(data);
        this.notifyAll();
    }

    //定义方法模拟出栈
    public synchronized void pop(){
        while (list.size()==0){
            try {
                System.out.println(Thread.currentThread().getName()+"pop  begin wait...");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"出栈数据"+list.remove(0));
        this.notifyAll();
    }

}
