package com.qing.thread02.cas;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/18 下午 02:56
 */
public class Test01 {
    public static void main(String[] args) {
        CASCounter casCount=new CASCounter();
        for (int i=0;i<100000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(casCount.incrementAndGet());
                }
            }).start();
        }


    }
}
class CASCounter{
    volatile private long value;
    public long getValue(){
        return value;
    }
    private boolean compareAndSwap(long expectedValue,long newValue){
        synchronized (this){
            if (value==expectedValue){
                value=newValue;
                return true;
            }else {
                return false;
            }
        }
    }
    public long incrementAndGet(){
        long oldValue;
        long newValue;
        do {
            oldValue = value;
            newValue = oldValue + 1;
        }while (!compareAndSwap(oldValue,newValue));
        return newValue;
    }
}
