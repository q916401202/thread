package com.qing.thread02.produerstack;

public class Test01 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        ProduerThread p = new ProduerThread(myStack);
        ConsumerThread c = new ConsumerThread(myStack);
        p.start();
        c.start();

    }
}
