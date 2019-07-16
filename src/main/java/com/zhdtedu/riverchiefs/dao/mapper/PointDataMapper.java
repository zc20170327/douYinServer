package com.zhdtedu.riverchiefs.dao.mapper;

import com.zhdtedu.riverchiefs.dao.entity.PointData;

public interface PointDataMapper {
    PointData  getPointData();
    int insert(PointData pointData);
    int deleteById(int id);
    int updateById(PointData pointData);
}
