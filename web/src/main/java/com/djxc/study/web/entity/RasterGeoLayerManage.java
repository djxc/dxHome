package com.djxc.study.web.entity;

import java.util.Date;

/**
 * 栅格图层的类
 * 继承于图层类
 * 1、除了GeoLayerMange类的属性还增加了路径以及分辨率属性。
 */
public class RasterGeoLayerManage extends GeoLayerManage {
    private String path;
    private float resolution;

    public RasterGeoLayerManage() {}

    public RasterGeoLayerManage(int id, String name, Date createDate, String path, float resolution) {
        super(id, name, createDate);
        this.path = path;
        this.resolution = resolution;
    }

    public RasterGeoLayerManage(int id, String name, String path, float resolution) {
        super(id, name);
        this.path = path;
        this.resolution = resolution;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getResolution() {
        return resolution;
    }

    public void setResolution(float resolution) {
        this.resolution = resolution;
    }
}
