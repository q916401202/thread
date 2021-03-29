package com.qing.thread02.producerdta;

public class ProducerThread extends Thread{
    private ValueOP op;

    public ProducerThread(ValueOP op) {
       this.op=op;
    }

    @Override
    public void run() {
        while (true){
            op.setValue();
        }
    }




}
