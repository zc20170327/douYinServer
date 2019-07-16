package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.util.RcsResult;
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
    public  PointData get(){
       PointData PointData=pointDataMapper.getPointData();
        return  PointData;
    }

    @Override
    public RcsResult insert(PointData pointData) {
        try{
            pointDataMapper.insert(pointData);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            pointDataMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult updatePointData(PointData pointData) {
            try{
                pointDataMapper.updateById(pointData);
            }catch (Exception e){
                e.printStackTrace();
                return  RcsResult.build(500,e.getMessage());

            }
            return RcsResult.ok();

    }


}
