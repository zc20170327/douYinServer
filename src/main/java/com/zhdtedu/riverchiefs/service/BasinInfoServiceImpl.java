package com.zhdtedu.riverchiefs.service;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.dao.entity.BasinInfoExample;
import com.zhdtedu.riverchiefs.dao.mapper.BasinInfoMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BasinInfoServiceImpl implements BasinInfoService {
    @Autowired
    private BasinInfoMapper basinInfoMapper;
    @Transactional(readOnly = true)
    @Override
    public RcsResult getBasinList(Long parentId, int pageNo) {
        List<BasinInfo> basinList= null;
        int pageSize=5;
        PageModel pageModel=null;
        try {
            PageHelper.startPage(pageNo,pageSize);

            Page<BasinInfo> page= (Page<BasinInfo>) basinInfoMapper.selectByBasinExample(parentId,pageNo,pageSize);
            pageModel=new PageModel(pageNo,(int)page.getTotal(),pageSize);
            pageModel.setList(page.getResult());
            pageModel.setTotalRecords((int)page.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            RcsResult.build(500,ExceptionUtil.getStackTrace(e));
        }
        return   RcsResult.ok(pageModel);
    }
    @Transactional(readOnly = true)
    @Override
    public int getTotalCount(Long parentId) {
        return basinInfoMapper.getTotalCount(parentId);
    }


    @Override
    public RcsResult saveBasin(BasinInfo basinInfo) {
        try{ basinInfo.setCreateTime(new Date());
            basinInfo.setUpdateTime(new Date());
            basinInfoMapper.insert(basinInfo);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,ExceptionUtil.getStackTrace(e));
        }
        return RcsResult.build(201,"新增成功",null);
    }
    @Transactional(readOnly = true)
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
        try{ basinInfo.setUpdateTime(new Date());
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
    @Transactional(readOnly = true)
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


