package com.qing.thread02.producerdta;

public class Test01 {
    public static void main(String[] args) {
        ValueOP valueOP = new ValueOP();
        ProducerThread p = new ProducerThread(valueOP);
        ConsumerThread c = new ConsumerThread(valueOP);

        p.start();
        c.start();


    }
}
