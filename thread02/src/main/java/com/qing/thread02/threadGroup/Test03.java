package com.qing.thread02.threadGroup;

public class Test03 {

    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("group1");

        ThreadGroup group2 = new ThreadGroup(threadGroup,"group2");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("-----当前线程：  "+Thread.currentThread());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(group1, runnable, "t2");
        Thread t3 = new Thread(group2, runnable, "t3");
        t1.start();
        t2.start();
        t3.start();


        Thread[] threads=new Thread[threadGroup.activeCount()];

//        threadGroup.enumerate(threads);
//        for (Thread thread : threads) {
//            System.out.println(thread);
//        }
        System.out.println("========================");
        threadGroup.enumerate(threads,false);
        for (Thread thread : threads) {
            System.out.println(thread);
        }

        System.out.println("-------------------------------------");
        ThreadGroup[] threadGroups = new ThreadGroup[threadGroup.activeGroupCount()];
        threadGroup.enumerate(threadGroups);
        for (ThreadGroup group : threadGroups) {
            System.out.println(group);
        }


//-----当前线程：  Thread[t1,5,main]
//Thread[main,5,main]
//Thread[Monitor Ctrl-Break,5,main]
//Thread[t1,5,main]
//null
//null
    }

}
