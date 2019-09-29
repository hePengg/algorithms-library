package com.dap.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        int bufferSize = 1024 * 1024;//环形队列长度，必须是2的N次方
        EventFactory<LongEvent> eventFactory = new LongEventFactory();
        /**
         * 定义Disruptor，基于单生产者，阻塞策略
         */
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(eventFactory, bufferSize, Executors.defaultThreadFactory(), ProducerType.SINGLE, new BlockingWaitStrategy());
        /////////////////////////////////////////////////////////////////////
        parallel(disruptor);//这里是调用各种不同方法的地方.
        /////////////////////////////////////////////////////////////////////
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        /**
         * 输入10
         */
        ringBuffer.publishEvent(new LongEventTranslator(), 10L);
//        ringBuffer.publishEvent(new LongEventTranslator(), 100L);
    }

    public static void parallel(Disruptor<LongEvent> disruptor) {
        disruptor.handleEventsWith(new C11EventHandler(), new C12EventHandler()).then(new TailEventHandler());

//        disruptor.handleEventsWith(new C11EventHandler());
//        disruptor.handleEventsWith(new C12EventHandler()).then(new TailEventHandler());
        disruptor.start();
    }
}
