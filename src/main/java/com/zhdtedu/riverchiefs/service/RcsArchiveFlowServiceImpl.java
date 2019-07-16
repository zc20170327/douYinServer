package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.mapper.RcsArchiveFlowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly =true)
public class RcsArchiveFlowServiceImpl implements RcsArchiveFlowService{

    @Autowired
    private RcsArchiveFlowMapper rcsArchiveFlowMapper;

    @Override
    public List<RcsArchiveFlow> getRcsArchiveFlowList() {
        return rcsArchiveFlowMapper.selectByExample(null);
    }
}
