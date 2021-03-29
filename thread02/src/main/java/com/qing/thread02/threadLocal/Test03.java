package com.qing.thread02.threadLocal;

import java.util.Date;

public class Test03 {
    static class SubThreadLocal extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return new Date(System.currentTimeMillis()-1000*60*15);
        }
    }

    static ThreadLocal threadLocal=new SubThreadLocal();
    static class SubThread extends Thread{
        @Override
        public void run() {
            for (int i=0;i<100;i++){
                System.out.println("            "+Thread.currentThread().getName()+"  value="+threadLocal.get());
                if (threadLocal.get()==null){
                    threadLocal.set(new Date());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.start();
        SubThread subThread1 = new SubThread();
        subThread1.start();
    }


}
