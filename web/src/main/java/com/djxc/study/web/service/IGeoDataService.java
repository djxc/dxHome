package com.djxc.study.web.service;



import com.djxc.study.demo.entity.GeoLayerManage;
import com.djxc.study.demo.entity.RasterGeoLayerManage;

import java.util.List;

/**
 * 导入数据
 * 1、栅格数据的导入，将tif放在指定目录下，然后调用python脚本进行切片，
 * 切片生成之后将栅格数据写入到raster_layer_manage数据表中。
 * 2、矢量数据导入，矢量数据分为shp、json以及kml(kmz)三种格式，采用java进行解析，
 * 然后将其导入postgresql数据库中，导入成功之后图层名称写入vector_layer_manage表中。
 */
public interface IGeoDataService {

    /**
     * **栅格数据的导入**
     * 1、首先判断rasterPath是否存在，如果不存在则返回false
     * 2、然后判断raster是否为tif格式，如果不是则返回false
     * 3、切片的导出位置需要在配置文件中配置。
     * 4、切片成功后需要在脚本中插入raster_layer_manage数据
     * @param rasterPath
     * @return
     */
    boolean importRaster(String rasterPath);

    /**
     * 矢量数据的导入
     * 1、首先判断vectorPath是否存在，以及其类型，本系统只支持kml(kmz)、json以及json格式。
     * 2、解析矢量文件，将其写入数据库
     * 3、导入成功后需要新增vector_layer_manage中一条记录。
     * @param vectorPath
     * @return
     */
    boolean importVector(String vectorPath);

    /**
     *
     * @return
     */
    List<RasterGeoLayerManage> selectAllRasterLayers();

    /**
     *
     * @return
     */
    List<GeoLayerManage> selectAllVectorLayers();

}
