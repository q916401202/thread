package com.qing.thread02.threadLocal;

public class Test01 {
    static ThreadLocal threadLocal=new ThreadLocal();

    static class SubThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                threadLocal.set(Thread.currentThread().getName()+"    "+i);
                System.out.println(Thread.currentThread().getName()+"   value="+threadLocal.get());
            }
        }
    }
    public static void main(String[] args) {
        SubThread t1 = new SubThread();
        SubThread t2 = new SubThread();
        t1.start();
        t2.start();
    }

}
