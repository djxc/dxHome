package com.djxc.study.web.entity;

import java.util.Date;

/**
 * 图层类，每个图层需要包含名称、创建时间
 * 1、客户端获取所有的图层数据，服务器需要在数据库中查询图层，封装为类数组，返回给前端。
 */
public class GeoLayerManage {
    private int id;
    private String name;
    private Date createDate;

    public GeoLayerManage() {}

    public GeoLayerManage(int id, String name, Date createDate) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
    }

    public GeoLayerManage(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
