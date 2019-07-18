package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.dao.entity.BaseDataExample;
import com.zhdtedu.system.dao.mapper.BaseDataMapper;
import com.zhdtedu.util.ExceptionUtil;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    private BaseDataMapper baseDataMapper;

    @Override
    public List<BaseData> getBaseDataList(Long parentId, int pageNo, int pageSize) {
        List<BaseData> baseDataList = baseDataMapper.selectByExample2(parentId, pageNo, pageSize);
        System.out.println("baseDataList" + baseDataList.get(0));
        return baseDataList;
    }

    @Override
    public int getTotalCount(Long parentId) {
        return baseDataMapper.getTotalCount(parentId);
    }

    @Override
    public BaseData getBaseData(long id) {
        BaseData baseData = baseDataMapper.selectByPrimaryKey(id);
        return baseData;
    }


    /*    @Transactional(rollbackFor = {RuntimeException.class, Error.class}*/
    @Override
    public RcsResult updateBaseData(BaseData baseData) {
        //补全字段在mapper中实现
        try {
            baseDataMapper.updateByPrimaryKey(baseData);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok();
    }

    @Override
    public RcsResult deleteBaseDataById(long id) {

        try {
            baseDataMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.build(200, "删除成功", null);
    }

    @Override
    public RcsResult saveBaseData(BaseData baseData) {
        try {
            baseDataMapper.insert(baseData);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, ExceptionUtil.getStackTrace(e));
        }

        return RcsResult.build(201, "新增成功", null);

    }

    @Override
    public RcsResult getNodeList() {
        List<BaseData> baseDataList = null;
        BaseDataExample example = new BaseDataExample();
        BaseDataExample.Criteria criteria = example.createCriteria();
        try {
            baseDataList = baseDataMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }
        return RcsResult.ok(baseDataList);
    }

}