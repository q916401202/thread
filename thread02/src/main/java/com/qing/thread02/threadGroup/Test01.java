package com.qing.thread02.threadGroup;

public class Test01 {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.toString());

        ThreadGroup group1=new ThreadGroup("group1");
        System.out.println(group1);

        ThreadGroup group2=new ThreadGroup(threadGroup,"group2");
        System.out.println(group2);

        System.out.println(group1.getParent()==threadGroup);
        System.out.println(group2.getParent()==threadGroup);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getThreadGroup());
            }
        };
        Thread t1 = new Thread(runnable, "t1");
        System.out.println(t1.toString());

        System.out.println(new Thread(group1,runnable,"t2"));
        System.out.println(new Thread(group2,runnable,"t3"));


    }


}
