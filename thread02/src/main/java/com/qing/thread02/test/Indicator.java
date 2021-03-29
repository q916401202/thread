package com.qing.thread02.test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author qing
 * @version 1.0
 * @date 2021/2/18 下午 04:34
 */
public class Indicator {
    private Indicator(){}

    private static final Indicator INSTANCE=new Indicator();
    public static Indicator getInstance(){
        return INSTANCE;
    }

    private final AtomicLong requestCount=new AtomicLong(0);
    private final AtomicLong successCount=new AtomicLong(0);
    private final AtomicLong failureCount=new AtomicLong(0);

    public void newRequestReceive(){
        requestCount.incrementAndGet();
    }
    public void newRequestSuccess(){
        successCount.incrementAndGet();
    }
    public void newRequestFailure(){
        failureCount.incrementAndGet();
    }

    public long getRequestCount(){
        return requestCount.get();
    }
    public long getSuccessCount(){
        return successCount.get();
    }
    public long getFailureCount(){
        return failureCount.get();
    }



}
