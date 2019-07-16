package com.zhdtedu.riverchiefs.service;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.util.RcsResult;

public interface PointDataService {
    ///获取检查点数据
    PointData get();
    //新增监测点数据
    RcsResult insert(PointData pointData);
    //根据监测点ID删除监测点
    RcsResult deleteById(int id);
    //根据监测点ID更新监测点
    RcsResult updatePointData(PointData pointData);

}
