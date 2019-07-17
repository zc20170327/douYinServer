package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfoExample;
import java.util.List;
import java.util.Map;

import com.zhdtedu.util.SearchCondition;
import org.apache.ibatis.annotations.Param;

public interface RcsArchiveInfoMapper {

    List<RcsArchiveInfo> pageQuery(Map<String,Object> param);

    int countByExample(RcsArchiveInfoExample example);

    int deleteByExample(RcsArchiveInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RcsArchiveInfo record);

    int insertSelective(RcsArchiveInfo record);

    List<RcsArchiveInfo> selectByExample(RcsArchiveInfoExample example);

    RcsArchiveInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RcsArchiveInfo record, @Param("example") RcsArchiveInfoExample example);

    int updateByExample(@Param("record") RcsArchiveInfo record, @Param("example") RcsArchiveInfoExample example);

    int updateByPrimaryKeySelective(RcsArchiveInfo record);

    int updateByPrimaryKey(RcsArchiveInfo record);
}