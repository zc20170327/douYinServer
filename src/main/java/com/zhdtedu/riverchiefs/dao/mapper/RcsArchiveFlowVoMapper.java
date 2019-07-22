package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RcsArchiveFlowVoMapper {
    /**
     * 查询所有代办案卷记录
     * @return
     */
      List<RcsArchiveFlowVo> selectRcsArchiveFlowVoList();

    /**
     * 根据输入条件查询所有代办案卷记录
     * @return
     */
     List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByCondition(RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 根据案卷编号查询vo对象
     * @param id
     * @return
     */
     RcsArchiveFlowVo getRcsArchiveFlowVoById(@Param("id") String id);

    /**
     * 已办案卷
     * @return
     */
     List<RcsArchiveFlowVo> selectRcsArchiveFlowVoHandledList();

    /**
     * 根据输入条件查询所有已办案卷列表
     * @param rcsArchiveFlowVo
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoHandledListByConditon(RcsArchiveFlowVo rcsArchiveFlowVo);

    /**
     * 已派列表
     * @return
     */
    List<RcsArchiveFlowVo>  selectRcsArchiveFlowVoDispatchedList();

    /**
     * 根据输入条件查询所有已派案卷列表
     * @param rcsArchiveFlowVo
     * @return
     */
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoDispatchedListByConditon(RcsArchiveFlowVo rcsArchiveFlowVo);
}