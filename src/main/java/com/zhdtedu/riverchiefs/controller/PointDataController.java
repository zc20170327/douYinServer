package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.riverchiefs.service.PointDataService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class PointDataController {
    /**
     * 获取检测点数据
     */
     @Autowired
    PointDataService pointDataService;

    @ApiOperation(value = "获取数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表")

    @GetMapping("/pointData/get")
    public PointData getBasinList() {

        return  pointDataService.getPointData();
    }
}
