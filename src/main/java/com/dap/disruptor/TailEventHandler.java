package com.dap.disruptor;

import com.lmax.disruptor.EventHandler;

public class TailEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("======END  ....." + longEvent.getNumber());
    }
}
