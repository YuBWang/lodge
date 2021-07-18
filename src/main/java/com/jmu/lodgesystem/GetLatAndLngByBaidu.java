package com.jmu.lodgesystem;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Formatter;

public class GetLatAndLngByBaidu {
    private static final double EARTH_RADIUS = 6371393;// 地球平均半径,单位：m
    private static final double raidus = 4000;//搜索半径，单位m
    /**	 * 通过AB点经纬度获取距离
     *  @return 距离(单位：米)	 */
    //根据地址获取经纬度
    public  double[] getCoordinate(String addr) throws IOException {
        String lng = null;// 经度
        String lat = null;// 纬度
        String address = null;
        try {
            address = java.net.URLEncoder.encode(addr, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String key = "ALKMKSksuc3ORlMLbH7jas7mHGk6o4mZ";
        String url = String.format("http://api.map.baidu.com/geocoder?address=%s&output=json&key=%s", address, key);
        URL myURL = null;
        URLConnection httpsConn = null;
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStreamReader insr = null;
        BufferedReader br = null;
        try {
            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
            if (httpsConn != null) {
                insr = new InputStreamReader(httpsConn.getInputStream(), "UTF-8");
                br = new BufferedReader(insr);
                String data = null;
                int count = 1;
                while ((data = br.readLine()) != null && (!data.equals("INVALID_PARAMETERS")) ) {
                    if (count == 5) {
                        lng = (String) data.subSequence(data.indexOf(":") + 1, data.indexOf(","));// 经度
                        count++;
                    } else if (count == 6) {
                        lat = data.substring(data.indexOf(":") + 1);// 纬度
                        count++;
                    } else {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (insr != null) {
                insr.close();
            }
            if (br != null) {
                br.close();
            }
        }
        double ln = Double.valueOf(lng);
        double la = Double.valueOf(lat);
        double []result= {ln,la};
        return result;

    }
    //根据两地经纬度计算距离
    public  double getDistance(Point2D pointA, Point2D pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(pointA.getX()); // A经弧度
        double radiansAY = Math.toRadians(pointA.getY()); // A纬弧度
        double radiansBX = Math.toRadians(pointB.getX()); // B经弧度
        double radiansBY = Math.toRadians(pointB.getY()); // B纬弧度
        // cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
        double acos = Math.acos(cos); // 反余弦值
        double len= EARTH_RADIUS * acos; // 最终结果
        double d = (double)Math.round(len*100)/100;
        return d;

    }
   //计算出目标一定范围内的经纬度
    public  double[] getAround(double lon, double lat) {
        Double latitude = lat;
        Double longitude = lon;
        Double degree = (24901 * 1609) / 360.0;
        double raidusMile = raidus;
        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * raidusMile;
        Double minLat = latitude - radiusLat;
        Double maxLat = latitude + radiusLat;
        Double mpdLng = Math.abs(degree * Math.cos(latitude * (Math.PI/ 180)));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * raidusMile;
        Double minLng = longitude - radiusLng;
        Double maxLng = longitude + radiusLng;
        return new double[] { minLng, minLat, maxLng, maxLat };
    }

}
