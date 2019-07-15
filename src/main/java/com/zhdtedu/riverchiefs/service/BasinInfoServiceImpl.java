package com.zhdtedu.riverchiefs.service;


import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfoExample;
import com.zhdtedu.riverchiefs.dao.mapper.BasinInfoMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasinInfoServiceImpl implements BasinInfoService {
    @Autowired
    private BasinInfoMapper basinInfoMapper;
    @Override
    public List<BasinInfo> getBasinList(Long parentId, int pageNo, int pageSize) {
        List<BasinInfo> basinList= basinInfoMapper.selectByBasinExample(parentId,pageNo,pageSize);
            return   basinList;
    }

    @Override
    public int getTotalCount(Long parentId) {
        return basinInfoMapper.getTotalCount(parentId);
    }


    @Override
    public RcsResult saveBasin(BasinInfo basinInfo) {
       try{
           basinInfoMapper.insert(basinInfo);
       }catch (Exception e){
           e.printStackTrace();
          return  RcsResult.build(500,ExceptionUtil.getStackTrace(e));
       }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult getBasinById(Long id) {
        BasinInfo basinInfo =null;
        try{
            basinInfo =   basinInfoMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok(basinInfo);
    }

    @Override
    public RcsResult updateBasin(BasinInfo basinInfo) {
        try{
            basinInfoMapper.updateByPrimaryKey(basinInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }

        return RcsResult.ok();
    }

    @Override
    public RcsResult deleteBasinById(Long id) {
       try{
           basinInfoMapper.deleteByPrimaryKey(id);
       }catch (Exception e){
           e.printStackTrace();
        return   RcsResult.build(500,e.getMessage());
       }
       return  RcsResult.build(204,"删除成功",null);
    }

    @Override
    public RcsResult getBasinNodeList() {
        List<BasinInfo> basinList=null;
        BasinInfoExample example= new BasinInfoExample();
        BasinInfoExample.Criteria criteria= example.createCriteria();
        try {
            basinList = basinInfoMapper.selectByExample(example);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.ok(basinList);
    }


    }


