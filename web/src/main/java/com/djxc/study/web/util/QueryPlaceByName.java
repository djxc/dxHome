package com.djxc.study.web.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 地名查询功能
 * 根据用户输入的地名访问天地图或是百度地图获取该地名的坐标位置
 */
public class QueryPlaceByName {
    private static String baiduServerKey = "kiHrcEFo2IGzo5NVZBmGBdKarxgu5HmH";
    private static String baiduAK = "vUBN58F9GiDvYgk6470fRuFD6xdrX2dv";
    private static String tiandituServerKey = "3d972853490532849e638e0127cab8e5";

    private String placeName = "";
    private String region = "全国";       // 范围具体到市可以查询到具体的数据，不然只有每个地区该地名的个数
    private StringBuffer document = new StringBuffer();

    public QueryPlaceByName(String placeName){
        this.placeName = placeName;
    }

    public QueryPlaceByName(String placeName, String region){
        this.placeName = placeName;
        this.region = region;
    }


    public static void main(String arsg[]) {
        QueryPlaceByName placeByName = new QueryPlaceByName("高庄", "山东");
        try{
            placeByName.GeoCoding(placeByName.placeName);
            placeByName.queryPlace();
        }catch (Exception e){

        }finally {

        }
    }

    /**
     * 	测试天地图的api
     * @throws Exception
     */
    private void GeoCoding(String place) throws Exception {
        String urlStr1 = "http://api.tianditu.gov.cn/geocoder?ds={'keyWord':'" +
                place + "}&tk=" + tiandituServerKey;
        String urlStr = "http://api.map.baidu.com/geocoding/v3/?address=" +
                place +"&output=json&ak=" + baiduServerKey;
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String line = null;
        while((line = reader.readLine())!=null) {
            document.append(line);
        }
        reader.close();
        System.out.println(document.toString());
    }

    /**
     * 通过百度接口获取ip地址的地理位置
     * @throws Exception
     */
    private void queryIPPlace() throws Exception{
        String myTK = "3d972853490532849e638e0127cab8e5";
        String urlStr = "http://api.map.baidu.com/location/ip?ak=vUBN58F9GiDvYgk6470fRuFD6xdrX2dv";
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                "utf-8"));
        String line = null;
        while((line = reader.readLine())!=null) {
            document.append(line);
        }
        reader.close();
        System.out.println(document.toString());
    }

    /**
     * 查询地名的地理位置
     * 需要输入需要查询的地名以及查询的范围，利用百度地图的api接口获取所有的结果
     * @throws Exception
     */
    public String queryPlace() {
        StringBuffer document = new StringBuffer();
        String urlStr = "http://api.map.baidu.com/place/v2/search?query=" +
                placeName + "&region=" + region +
                "&page_size=200&page_num=0&output=json&ak=" + baiduServerKey;
        try{
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),
                    "utf-8"));
            String line = null;
            while((line = reader.readLine())!=null) {
                document.append(line);
            }
            reader.close();
            System.out.println(document.toString());
        }catch (Exception e) {

        }finally {
            return document.toString();
        }
    }

    /**
     * 获取百度api的结果，将其转换为json对象，然后返回
     * @param region
     * @return
     */
    private String converApiResult2Json(String placeName, String region){
        String urlStr = "http://api.map.baidu.com/place/v2/search?query=" + placeName +
                "&region=" + region + "&page_size=200&page_num=0&output=json&ak=" + baiduAK;
        StringBuffer document = new StringBuffer();
        String json = null;
        try{
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            while((line = reader.readLine())!=null) {
                document.append(line);
            }
            reader.close();
            json = document.toString();
        }catch (Exception e){

        }finally {
            return json;
        }
    }

}
