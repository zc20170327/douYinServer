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
     * 插入历史操作记录
     */
    public void insertRcsArchiveFlow(RcsArchiveFlow rcsArchiveFlow);

    /**
     * 根据id查询案卷登记信息
     * @param id
     * @return
     */
    public RcsArchiveInfo queryRcsArchiveInfoById(Integer id);

    /**
     * 修改案卷登记信息中的status
     * @param rcsArchiveInfo
     */
    public void modifyRcsArchiveInfo(RcsArchiveInfo rcsArchiveInfo);

}
