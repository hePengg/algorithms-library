package com.dap.spider.sync;

import com.csvreader.CsvWriter;
import com.dap.spider.SpiderMain;
import com.dap.spider.SysArea;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class SpiderSync {

    /**
     * 本示例只爬取宁夏回族自治区五级行政区划的信息ƒ
     */
    private static String CUST_NAME = "广东省";
    private static String URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2021/index.html";

    private static final String PATH = "/Users/hepeng/tools/zz/";

    public static void main(String[] args) throws IOException, InterruptedException {
        List<SysArea> sysAreas = getProvinces(URL);

//        System.err.println("插入数据条数：" + sysAreas.size());
    }

    /**
     * 获取所有的省份（本示例只爬取宁夏回族自治区五级行政区划的信息）
     *
     * @param url 请求地址：http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2021/index.html
     * @return
     */
    public static List<SysArea> getProvinces(String url) {
        // 线程安全的list
        List<SysArea> sysAreas = Collections.synchronizedList(new ArrayList<>());
        Document connect = SpiderProcess.connect(url);
        Elements rowProvince = connect.select("tr.provincetr");

        for (Element provinceElement : rowProvince) {
            Elements select = provinceElement.select("a");
            for (Element province : select) {
                if (province.text().equals("福建省")) {
                    new Thread1(province, url).start();
                }
            }
        }
        return sysAreas;
    }

}
