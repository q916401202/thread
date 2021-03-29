package com.qing.thread02.produerstack;

public class Test02 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        ProduerThread p = new ProduerThread(myStack);
        ConsumerThread c1 = new ConsumerThread(myStack);
        ConsumerThread c2 = new ConsumerThread(myStack);
        ConsumerThread c3 = new ConsumerThread(myStack);
        ConsumerThread c4 = new ConsumerThread(myStack);
        ConsumerThread c5 = new ConsumerThread(myStack);

        c1.setName("消费者1号");
        c2.setName("消费者2号");
        c3.setName("消费者3号");
        c4.setName("消费者4号");
        c5.setName("消费者5号");
        p.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();

    }
}
