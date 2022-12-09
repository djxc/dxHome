package com.djxc.study.web.controller;

import com.djxc.study.demo.entity.GeoLayerManage;
import com.djxc.study.demo.entity.RasterGeoLayerManage;
import com.djxc.study.demo.service.IGeoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地理数据管理
 * 1、栅格数据的导入，将tif放在指定目录下，系统会调用python脚本进行切片，
 * 2、矢量数据导入，用户需要上传矢量文件，系统将其写入到数据库中。
 * 3、核查照片的导入
 * 4、飞防数据导入
 * 5、栅格数据图层查询
 * 6、矢量数据图层查询
 */
@RestController
@RequestMapping("/geodata")
public class GeoDataController {

    @Autowired
    private IGeoDataService geoDataService;

    /**
     * 无人机影像的导入
     * @return
     */
    @RequestMapping(value = "/importRaster", method = RequestMethod.GET)
    public boolean rasterImport(@RequestParam String rasterPath){
        boolean isOK = geoDataService.importRaster(rasterPath);
        return isOK;
    }

    /**
     * 矢量数据的导入
     * @return
     */
    @RequestMapping(value = "/importVector", method = RequestMethod.GET)
    public boolean vectorImport(){
        return true;
    }

    /**
     * 矢量图层的查询
     * @return
     */
    @RequestMapping(value = "/queryVectorLayer", method = RequestMethod.GET)
    public List<GeoLayerManage> vectorQuery() {
        List<GeoLayerManage> vectorLayer = geoDataService.selectAllVectorLayers();
        return vectorLayer;
    }

    /**
     * 栅格图层的查询
     * @return
     */
    @RequestMapping(value = "/queryRasterLayer", method = RequestMethod.GET)
    public List<RasterGeoLayerManage> rasterQuery() {
        List<RasterGeoLayerManage> rasterLayer = geoDataService.selectAllRasterLayers();
        return rasterLayer;
    }

}
