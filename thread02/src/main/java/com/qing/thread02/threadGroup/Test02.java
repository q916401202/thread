package com.qing.thread02.threadGroup;

public class Test02 {

    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group = new ThreadGroup("group");
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                while (true){
                    System.out.println("----- 当前线程 "+Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable,"t1");
        Thread t2 = new Thread(group,runnable,"t2");
        t1.start();
        t2.start();

        System.out.println("main  线程组中的活动数量  "+threadGroup.activeCount());
        System.out.println("group 子线程组中活动线程数量 "+ group.activeCount());
        System.out.println("main线程组中子线程组数量 "+threadGroup.activeGroupCount());
        System.out.println("group 子线程组中子线程组数量 "+ group.activeGroupCount());
        System.out.println("main 线程组的父线程组： "+threadGroup.getParent());
        System.out.println("group 线程组的父线程组： "+group.getParent());
        System.out.println(threadGroup.parentOf(threadGroup));
        System.out.println(threadGroup.parentOf(group));
        threadGroup.list();

    }



}
