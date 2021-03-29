package com.qing.thread02.produerstack;

public class ConsumerThread extends Thread {
    private MyStack myStack;

    ConsumerThread(MyStack myStack){
        this.myStack=myStack;
    }



    @Override
    public void run() {
        while (true){
            myStack.pop();
        }
    }

}
