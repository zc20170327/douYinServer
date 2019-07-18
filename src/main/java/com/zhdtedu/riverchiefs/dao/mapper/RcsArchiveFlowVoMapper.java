package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RcsArchiveFlowVoMapper {
    int countByExample(RcsArchiveFlowVoExample example);

    int deleteByExample(RcsArchiveFlowVoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RcsArchiveFlowVo record);

    int insertSelective(RcsArchiveFlowVo record);

    List<RcsArchiveFlowVo> selectByExample(RcsArchiveFlowVoExample example);

    RcsArchiveFlowVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RcsArchiveFlowVo record, @Param("example") RcsArchiveFlowVoExample example);

    int updateByExample(@Param("record") RcsArchiveFlowVo record, @Param("example") RcsArchiveFlowVoExample example);

    int updateByPrimaryKeySelective(RcsArchiveFlowVo record);

    int updateByPrimaryKey(RcsArchiveFlowVo record);
    
    List<RcsArchiveFlowVo> selectRcsArchiveFlowVoByExample(@Param("example") RcsArchiveFlowVoExample example);
}