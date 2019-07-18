package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;

import java.util.List;

public interface RcsArchiveFlowVoMapper {
    /**
     * 查询所有代办案卷记录
     * @return
     */
      List<RcsArchiveFlowVo> selectRcsArchiveFlowVoList();

    /**
     * 查询所有代办案卷记录
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByCondition(RcsArchiveFlowVo rcsArchiveFlowVo);
}