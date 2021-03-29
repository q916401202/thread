package com.qing.thread02.threadLocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");



    static ThreadLocal<SimpleDateFormat>  threadLocal=new ThreadLocal<>();
    static class ParseDate implements Runnable{
        int i=0;
        public ParseDate(int i){
            this.i=i;
        }

        @Override
        public void run() {
            try {
                String text="2068年11月22日 08:28:"+i%60;


                if (threadLocal.get()==null){
                    threadLocal.set(new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"));
                }



                Date parse = threadLocal.get().parse(text);

                System.out.println(i+"---"+parse);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {

        for (int i=0;i<100;i++){
            new Thread(new ParseDate(i)).start();
        }


    }
}
