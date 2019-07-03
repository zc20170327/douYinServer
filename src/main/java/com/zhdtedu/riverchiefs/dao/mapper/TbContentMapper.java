package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.bean.TbContent;
import com.zhdtedu.riverchiefs.bean.TbContentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层实现Mybatis框架中的Mapper接口，声名对数据库的操作方法
 *
 *
 */
@Mapper
public interface TbContentMapper {
    int countByExample(TbContentExample example);

    int deleteByExample(TbContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbContent record);

    int insertSelective(TbContent record);

    List<TbContent> selectByExampleWithBLOBs(TbContentExample example);

    List<TbContent> selectByExample(TbContentExample example);

    TbContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExampleWithBLOBs(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByExample(@Param("record") TbContent record, @Param("example") TbContentExample example);

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);
    List<TbContent> selectByExample2(@Param("parentId") long   parentId,
                                     @Param("pageNo") Integer   pageNo,
                                     @Param("pageSize") Integer   pageSize);
    int getTotalCount(@Param("parentId") long   parentId,
                      @Param("pageNo") Integer   pageNo,
                      @Param("pageSize") Integer   pageSize);

}