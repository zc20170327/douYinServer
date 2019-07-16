package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;

import java.util.List;

public interface RcsArchiveFlowService {
    /**
     * 获取所有历史处理记录
     * @return
     */
    public List<RcsArchiveFlow> getRcsArchiveFlowList();

    /**
     * 插入操作处理
     */
    public void insertRcsArchiveFlow(RcsArchiveFlow rcsArchiveFlow);

    /**
     * 修改案卷登记状态
     * @param status
     */
    public void updateRcsArchiveInfoStatus(RcsArchiveInfo rcsArchiveInfo);
}
