package com.djxc.study.web.service.impl;

import com.djxc.study.demo.entity.GeoLayerManage;
import com.djxc.study.demo.entity.RasterGeoLayerManage;
import com.djxc.study.demo.service.IGeoDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoDataServiceServiceImpl implements IGeoDataService {
    @Override
    public boolean importRaster(String rasterPath) {
        return false;
    }

    @Override
    public boolean importVector(String vectorPath) {
        return false;
    }

    @Override
    public List<RasterGeoLayerManage> selectAllRasterLayers() {
        return null;
    }

    @Override
    public List<GeoLayerManage> selectAllVectorLayers() {
        return null;
    }

//    @Autowired
//    GeoLayerManageMapper layerManageMapper;
//
//    @Override
//    public boolean importRaster(String rasterPath) {
//        System.out.println(rasterPath);
//        return false;
//    }
//
//    @Override
//    public boolean importVector(String vectorPath) {
//        return false;
//    }
//
//    @Override
//    public List<RasterGeoLayerManage> selectAllRasterLayers() {
//        return layerManageMapper.getRasterLayers();
//    }
//
//    @Override
//    public List<GeoLayerManage> selectAllVectorLayers() {
//        return layerManageMapper.getVectorLayers();
//    }
}
