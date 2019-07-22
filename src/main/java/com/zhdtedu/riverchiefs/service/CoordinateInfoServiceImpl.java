package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;
import com.zhdtedu.riverchiefs.dao.mapper.CoordinateInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("coordinateInfoService")
public class CoordinateInfoServiceImpl implements  CoordinateInfoService{

    @Resource
    private CoordinateInfoMapper coordinateInfoMapper;

    @Override
    public void add(RcsCoordinateInfo rcif) {
        this.coordinateInfoMapper.insert(rcif);
    }

    @Override
    public RcsCoordinateInfo getRcsCoordinateInfo(Integer id) {
        return this.coordinateInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteRcsCoordinateInfo(Integer id) {
        this.coordinateInfoMapper.deleteById(id);
    }
}
