package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveInfoMapper;
import com.zhdtedu.util.SearchCondition;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(readOnly =true)
public class RcsArchiveInfoServiceImpl implements  RcsArchiveInfoService{

    @Resource
    private RcsArchiveInfoMapper rcsArchiveInfoMapper;


    @Override
    public List<RcsArchiveInfo> pageQuery(SearchCondition sc){
        List<RcsArchiveInfo> list  = this.rcsArchiveInfoMapper.pageQuery(sc);
        return list;
    }

    @Override
    public RcsArchiveInfo getRcsArchiveInfo(Integer id) {
        return rcsArchiveInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void addRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo) {
        rcsArchiveInfoMapper.insert(rcsArchiveInfo);
    }

    @Override
    @Transactional(readOnly = false)
    public void modifyRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo) {
        this.rcsArchiveInfoMapper.updateByPrimaryKey(rcsArchiveInfo);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRcsArchiveInfo(Integer id){
        this.deleteRcsArchiveInfo(id);
    }
}
