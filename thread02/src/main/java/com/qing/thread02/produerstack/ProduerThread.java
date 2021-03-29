package com.qing.thread02.produerstack;

public class ProduerThread extends Thread {
    private MyStack myStack;

    ProduerThread(MyStack myStack){
        this.myStack=myStack;
    }



    @Override
    public void run() {
        while (true){
            myStack.push();
        }
    }

}
