package com.qing.thread01.thread14;

/**
 * @author qing
 * @version 1.0
 * @date 2021/1/11 上午 11:15
 */
public class Test01 {
    public static void main(String[] args) throws Exception {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask);
        thread.start();
        Thread.sleep(1000);
        myTask.cancel();
        /**
         * 在main线程中调用了myTask（）方法，把fig设置为true,可能子线程看不到main线程对doSomething做的修改，在子线程中doSomething变量一直为false，
         * 导致子线程看不到main线程对doSomething变量更新的原因
         */
    }


    static class MyTask implements Runnable {
        private boolean flg = false;

        @Override
        public void run() {
            while (!flg) {
                if (doSomething()) {
//                    break;
                }
            }
            if (flg) {
                System.out.println("任务取消");
            } else {
                System.out.println("任务正常结束");
            }
        }

        public boolean doSomething() {
            System.out.println("执行某个任务");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

        public void cancel() {
            flg = true;
            System.out.println("收到 取消线程消息");
        }
    }
}

