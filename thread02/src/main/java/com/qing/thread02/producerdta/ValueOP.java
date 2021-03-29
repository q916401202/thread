package com.qing.thread02.producerdta;

public class   ValueOP {
    private String value = "";

    public void setValue() {
        synchronized (this) {
            while (value.equalsIgnoreCase("")) {
                String value = System.currentTimeMillis() + "-" + System.nanoTime();
                System.out.println("set设置得值是：" + value);
                this.value = value;
                this.notify();
            }
        }
    }

    public void getValue() {
        synchronized (this) {
            while (value.equalsIgnoreCase("")) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("get得值是:" + this.value);
            this.value = "";
            this.notify();
        }
    }

}
