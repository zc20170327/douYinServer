package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlowExample;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowMapper;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RcsArchiveFlowServiceImpl implements RcsArchiveFlowService{

    @Autowired
    private RcsArchiveFlowMapper rcsArchiveFlowMapper;

    @Autowired
    private RcsArchiveInfoMapper rcsArchiveInfoMapper;

    @Override
    public List<RcsArchiveFlow> getRcsArchiveFlowList() {
        RcsArchiveFlowExample example = new RcsArchiveFlowExample();
        return rcsArchiveFlowMapper.selectByExample(example);
    }

    @Override
    public void insertRcsArchiveFlow(RcsArchiveFlow rcsArchiveFlow) {
        rcsArchiveFlowMapper.insert(rcsArchiveFlow);
    }

    @Override
    public RcsArchiveInfo queryRcsArchiveInfoById(Integer id) {
        return rcsArchiveInfoMapper.selectByPrimaryKey(id);
    }

}
