package com.qing.thread02.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Test01 {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);
         new Thread(new Runnable() {
            @Override
            public void run() {
                writeData(pipedOutputStream);
            }
        }).start();
         new Thread(new Runnable() {
            @Override
            public void run() {
                readData(pipedInputStream);
            }
        }).start();

    }

    public static void writeData(PipedOutputStream outputStream) {
        try {
            for (int i = 0; i < 100; i++) {
                String data = " " + i;

                //把字节数组写入到输出管道流中
                outputStream.write(data.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readData(PipedInputStream inputStream){
        byte[] bytes = new byte[1024];
        try {
            int read = inputStream.read(bytes);
            while (read!=-1){
                System.out.println(new String(bytes,0,read));
                read=inputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
