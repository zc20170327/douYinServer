package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.riverchiefs.dao.mapper.PointInfoMapper;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PointInfoServiceImpl implements PointInfoService {
    @Autowired
    private PointInfoMapper pointInfoMapper;
    @Override
    public List<PointInfo> getPointInfoList(Long code, String name,int pageNo, int pageSize) {
        List<PointInfo> basinList= pointInfoMapper.selectByBasinExample(code,name,pageNo,pageSize);
        return   basinList;
    }

    @Override
    public int getTotalCount(Long code, String name){
        return pointInfoMapper.getTotalCount(code,name);
    }

    @Override
    public RcsResult savePointInfo(PointInfo pointInfo) {
        try{
            pointInfoMapper.insert(pointInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);

    }

    @Override
    public RcsResult getPointInfoById(Long id) {
        PointInfo pointInfo =null;
        try{
            pointInfo =   pointInfoMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok(pointInfo);

    }

    @Override
    public RcsResult updatePointInfo(PointInfo pointInfo) {

        try{
            pointInfoMapper.updateByPrimaryKey(pointInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }

        return RcsResult.ok();
    }

    @Override
    public RcsResult deletePointInfoById(Long id) {
        try{
            pointInfoMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();


    }





}
