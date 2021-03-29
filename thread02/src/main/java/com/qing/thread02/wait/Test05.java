package com.qing.thread02.wait;

import java.util.ArrayList;
import java.util.List;

public class Test05 {
    public static List list = new ArrayList<>();

    public static void main(String[] args) {
        ThreadAdd threadAdd = new ThreadAdd();
        ThreadSubtract threadSubtract = new ThreadSubtract();
        //先添加数据，在取数据，大多数情况下正常取数据
//        threadAdd.start();
//        threadSubtract.start();

//        threadSubtract.start();
//        threadAdd.start();

        ThreadSubtract threadSubtract1 = new ThreadSubtract();
        threadSubtract1.setName("te   ");
        threadSubtract1.start();
        threadSubtract.start();
        threadAdd.start();





    }


    public static void subtract() {
        synchronized (list) {
            while (list.size() == 0) {
                try {
                    System.out.println(Thread.currentThread().getName() + "begin wait...");
                    list.wait();
                    System.out.println(Thread.currentThread().getName() + "end  wait ...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Object remove = list.remove(0);
            System.out.println(Thread.currentThread().getName() + "从集合中取了" + remove + "，剩余" + list.size());
        }
    }

    public static void add() {
        synchronized (list) {
            list.add("data");
            list.notifyAll();
        }
    }

    static class ThreadAdd extends Thread {
        @Override
        public void run() {
            add();
        }
    }

    static class ThreadSubtract extends Thread {
        @Override
        public void run() {
            subtract();
        }
    }

}
