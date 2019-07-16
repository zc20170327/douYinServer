package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RcsArchiveFlowVoMapper {

    /**
     * 查询案卷代办列表
     * @return
     */
    public List<RcsArchiveFlowVo> findRcsArchiveFlowVoList();

}