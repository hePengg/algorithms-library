package com.dap.spider;

import com.alibaba.fastjson.JSON;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpiderMain {

    /**
     * 本示例只爬取宁夏回族自治区五级行政区划的信息
     */
    private static String allName = "北京市";

    private static String URL = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2021/index.html";

    private static final Map<String, Connection> connectionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<SysArea> sysAreas = getProvinces(URL);
//        System.err.println("爬虫相应数据为："+ JSON.toJSONString(sysAreas));
        System.err.println("插入数据条数："+ sysAreas.size());

        // 写入文件
        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/hepeng/tools/zz/test.json"));
        out.write(JSON.toJSONString(sysAreas));
        out.close();
        System.out.println("文件创建成功！");
    }

    static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36";

    /**
     * 建立连接
     */
    private static Document connect(String url) {
        if (url == null || url.isEmpty()) {
            throw new IllegalArgumentException("无效的url");
        }
        try {
            if (!connectionMap.containsKey(url)) {
                Connection connection = Jsoup.connect(url).timeout(5 * 1000).userAgent(USER_AGENT);
                connectionMap.put(url, connection);
            }

            return connectionMap.get(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("请求失败：" + url);
            System.out.println("进行重试：" + url);
            return connect(url);
        }
    }

    /**
     * 获取所有的省份（本示例只爬取宁夏回族自治区五级行政区划的信息）
     * @param url 请求地址：http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2021/index.html
     * @return
     */
    public static List<SysArea> getProvinces(String url) {
        List<SysArea> sysAreas = new ArrayList<>();
        Document connect = connect(url);
        Elements rowProvince = connect.select("tr.provincetr");

//        Elements elements = new Elements(rowProvince.get(0));

//        for (Element provinceElement : elements) {
        for (Element provinceElement : rowProvince) {
            Elements select = provinceElement.select("a");
            for (Element province : select) {

                if(province.text().equals(allName)){
                    String code = province.select("a").attr("href");
                    String name = province.text();
                    SysArea sysArea = new SysArea();
                    sysArea.setAreaCode(code.replace(".html","0000000000"));
                    sysArea.setId(sysArea.getAreaCode());
                    sysArea.setAreaName(name);
                    sysArea.setLevel("1");
                    sysArea.setParentCode("0");
                    sysArea.setDelFlag("1");
                    sysArea.setStatus("1");
                    sysArea.setFullName(name);
                    sysAreas.add(sysArea);
                    String provinceUrl = url.replace("index.html",code);
                    System.err.println("++++++++++++++++++++++++++开始获取"+ name +"下属市区行政区划信息++++++++++++++++++++++++");
                    List<SysArea> cityAreaCodeList = getCityAreaCode(provinceUrl,code.replace(".html","0000000000"),name);
                    sysAreas.addAll(cityAreaCodeList);
                }
            }
        }
        return sysAreas;
    }


    /**
     * 获取市行政区划信息
     * @param provinceUrl 省份对应的地址
     * @param parentCode  需要爬取的省份行政区划（对于市的父级代码即为省行政区划）
     * @return
     */
    public static List<SysArea> getCityAreaCode(String provinceUrl,String parentCode,String upAreaName){
        List<SysArea> sysAreas = new ArrayList<>();
        Document connect = connect(provinceUrl);
        Elements rowCity = connect.select("tr.citytr");
        for (Element cityElement : rowCity) {
            String name = cityElement.select("td").text();
            String[] split = name.split(" ");
            SysArea sysArea = new SysArea();
            sysArea.setAreaCode(split[0]);
            sysArea.setAreaName(split[1]);
            sysArea.setParentCode(parentCode);
            sysArea.setLevel("2");
            sysArea.setDelFlag("1");
            sysArea.setStatus("1");
            sysArea.setFullName(upAreaName+split[1]);
            sysArea.setId(sysArea.getAreaCode());
            sysAreas.add(sysArea);
            String cityUrl = provinceUrl.replace(".html","/"+split[0].substring(0, 4)+".html");
            System.err.println("-------------------开始获取"+split[1]+"下属区县行政区划信息-----------------------");
            List<SysArea> downAreaCodeList = getDownAreaCode(cityUrl,split[0],upAreaName+split[1]);
            sysAreas.addAll(downAreaCodeList);
            //只爬取固原市的数据
            /*if("固原市".equals(split[1])){

            }*/
        }
        return sysAreas;
    }

    /**
     * 获取区县行政区划信息
     * @param cityUrl 城市对应的地址
     * @param parentCode  需要爬取的市行政区划（对于区县的父级代码即为市行政区划）
     * @return
     */
    public static List<SysArea> getDownAreaCode(String cityUrl,String parentCode,String upAreaName){
        List<SysArea> sysAreas = new ArrayList<>();
        Document connect = connect(cityUrl);
        Elements rowDown = connect.select("tr.countytr");
        for (Element downElement : rowDown) {
            String code = downElement.select("a").attr("href");
            String name = downElement.select("td").text();
            String[] split = name.split(" ");
            if(!"市辖区".equals(split[1])){
                SysArea sysArea = new SysArea();
                sysArea.setAreaCode(split[0]);
                sysArea.setAreaName(split[1]);
                sysArea.setParentCode(parentCode);
                sysArea.setLevel("3");
                sysArea.setDelFlag("1");
                sysArea.setStatus("1");
                sysArea.setFullName(upAreaName+split[1]);
                sysArea.setId(sysArea.getAreaCode());
                sysAreas.add(sysArea);
                String downUrl = cityUrl.replace(parentCode.substring(0,4)+".html",code);
                System.err.println("====================开始获取"+split[1]+"下属区划信息");
                List<SysArea> countryAreaList = getCountryAreaCodeList(downUrl,split[0],upAreaName+split[1]);
                sysAreas.addAll(countryAreaList);
            }
        }
        return sysAreas;
    }


    /**
     * 获取乡镇行政区划信息
     * @param downUrl
     * @param parentCode
     * @return
     */
    public static List<SysArea> getCountryAreaCodeList(String downUrl,String parentCode,String upAreaName){
        List<SysArea> sysAreas = new ArrayList<>();
        Document connect = connect(downUrl);
        Elements rowDown = connect.select("tr.towntr");
        for (Element downElement : rowDown) {
            String code = downElement.select("a").attr("href");
            String name = downElement.select("td").text();
            String[] split = name.split(" ");
            SysArea sysArea = new SysArea();
            sysArea.setAreaCode(split[0]);
            sysArea.setAreaName(split[1]);
            sysArea.setParentCode(parentCode);
            sysArea.setLevel("4");
            sysArea.setDelFlag("1");
            sysArea.setStatus("1");
            sysArea.setFullName(upAreaName+split[1]);
            sysArea.setId(sysArea.getAreaCode());
            sysAreas.add(sysArea);
            String countryUrl = downUrl.replace(parentCode.substring(0,6)+".html",code);
            System.err.println("====================开始获取"+split[1]+"下属区划信息");
            List<SysArea> villageAreaCodeList = getVillageAreaCodeList(countryUrl,split[0],upAreaName+split[1]);
            sysAreas.addAll(villageAreaCodeList);
        }
        return sysAreas;
    }


    /**
     * 获取村行政区划信息
     * @param countryUrl
     * @param parentCode
     * @return
     */
    public static List<SysArea> getVillageAreaCodeList(String countryUrl,String parentCode,String upAreaName){
        List<SysArea> villageAreaCodeList = new ArrayList<>();
        Document connect = connect(countryUrl);
        Elements rowDown = connect.select("tr.villagetr");
        for (Element downElement : rowDown) {
            String name = downElement.select("td").text();
            String[] split = name.split(" ");
            SysArea sysArea = new SysArea();
            sysArea.setAreaCode(split[0]);
            sysArea.setAreaName(split[2]);
            sysArea.setParentCode(parentCode);
            sysArea.setLevel("5");
            sysArea.setDelFlag("1");
            sysArea.setStatus("1");
            sysArea.setId(sysArea.getAreaCode());
            sysArea.setFullName(upAreaName+split[2]);
            villageAreaCodeList.add(sysArea);
        }
        return villageAreaCodeList;
    }
}
