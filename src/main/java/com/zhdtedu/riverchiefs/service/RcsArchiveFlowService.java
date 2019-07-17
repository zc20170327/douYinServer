package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;

import java.util.List;

public interface RcsArchiveFlowService {
    /**
     * 获取所有历史处理记录
     * @return
     */
    public List<RcsArchiveFlow> getRcsArchiveFlowList();
}
