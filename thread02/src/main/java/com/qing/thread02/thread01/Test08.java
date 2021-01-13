package com.qing.thread02.thread01;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/13 上午 11:08
 */
public class Test08 {
    public static void main(String[] args) throws Exception {
        PublicValue publicValue =new PublicValue();
        SubThred subThred=new SubThred(publicValue);
        subThred.start();

        Thread.sleep(100);

        publicValue.getValue();

    }

    static  class SubThred extends Thread{
        private PublicValue publicValue;
        public SubThred(PublicValue publicValue){
            this.publicValue=publicValue;
        }

        @Override
        public void run() {
            publicValue.setValue("asbcjask","1243");
        }
    }

    static class PublicValue{
        private String name="wkcto";
        private String pwd="666";

        public synchronized void getValue(){
            System.out.println(Thread.currentThread().getName()+"   ,getter----name:"+name+",  pwd:"+pwd);
        }

        public synchronized void setValue(String name,String pwd){
            this.name=name;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.pwd=pwd;
            System.out.println(Thread.currentThread().getName()+"      ,setter ---name:"+name+",  pwd:"+pwd);

        }
    }
}
