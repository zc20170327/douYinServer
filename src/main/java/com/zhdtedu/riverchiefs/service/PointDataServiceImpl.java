package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointDataServiceImpl implements  PointDataService{
    @Autowired
    PointDataMapper pointDataMapper;

    /**
     * 获取检测点信息
     * @return
     */
    @Override
    public  PointData getPointData(){
       PointData PointData=pointDataMapper.getPointData();
        return  PointData;
    };

}
