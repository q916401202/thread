package com.qing.thread02.producerdta;

public class Test02 {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();
        ProducerThread p1 = new ProducerThread(valueOP);
        ConsumerThread c1 = new ConsumerThread(valueOP);
        ProducerThread p2 = new ProducerThread(valueOP);
        ConsumerThread c2 = new ConsumerThread(valueOP);
        ProducerThread p3 = new ProducerThread(valueOP);
        ConsumerThread c3 = new ConsumerThread(valueOP);
        ProducerThread p4 = new ProducerThread(valueOP);
        ConsumerThread c4 = new ConsumerThread(valueOP);
        ProducerThread p5 = new ProducerThread(valueOP);
        ConsumerThread c5 = new ConsumerThread(valueOP);

        p1.start();
        c1.start();
        p2.start();
        c2.start();
        p3.start();
        c3.start();
        p4.start();
        c4.start();
        p5.start();
        c5.start();


    }
}
