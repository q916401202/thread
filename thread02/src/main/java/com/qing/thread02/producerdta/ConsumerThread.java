package com.qing.thread02.producerdta;

public class ConsumerThread extends Thread{
    private ValueOP op;

    public ConsumerThread(ValueOP op) {
       this.op=op;
    }

    @Override
    public void run() {
        while (true){
            op.getValue();
        }
    }




}
