package com.dap.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class C11EventHandler implements EventHandler<LongEvent>, WorkHandler<LongEvent> {
//public class C11EventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        long number = event.getNumber();
        number += 10;
        Thread.sleep(10000);
        System.out.println(System.currentTimeMillis() + ": E-c1-1 consumer finished.number=" + number);
    }

    @Override
    public void onEvent(LongEvent event) throws Exception {
        long number = event.getNumber();
        number += 10;
        System.out.println(System.currentTimeMillis() + ": W-c1-1 consumer finished.number=" + number);
    }
}
