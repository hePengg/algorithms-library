package com.dap.spider.sync;

import com.dap.spider.SysArea;
import org.jsoup.nodes.Element;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Thread1 extends Thread {

    private Element province;
    private String url;

    public Thread1(Element province, String url) {
        this.province = province;
        this.url = url;
    }

    @Override
    public void run() {
        SpiderProcess spiderProcess = new SpiderProcess();

        SpiderProcess.processProvince(province, url);
    }
}
