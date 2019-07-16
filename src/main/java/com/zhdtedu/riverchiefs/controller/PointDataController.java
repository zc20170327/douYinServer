package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.dao.entity.PointData;
import com.zhdtedu.riverchiefs.dao.entity.PointInfo;
import com.zhdtedu.riverchiefs.dao.mapper.PointDataMapper;
import com.zhdtedu.riverchiefs.service.PointDataService;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1")
public class PointDataController {
    /**
     * 获取检测点数据
     */
     @Autowired
    PointDataService pointDataService;

    @ApiOperation(value = "获取监测点数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表")

    @GetMapping("/pointData/get")
    public PointData getBasinList() {

        return  pointDataService.get();
    }

    /**
     * 新增监测点数据信息
     */

    @ApiOperation(value = "新增监测点数据信息", notes = "新增监测点数据信息")
    @ApiImplicitParam(name = "pointData", value = "pointData", required = true, dataType = "PointData")
    @PostMapping("/pointsData/insert")
    public RcsResult insertPointData(@RequestBody PointData pointData) {
        RcsResult result = pointDataService.insert(pointData);
        return result;
    }
    /**
     * 删除监测点数据信息
     */
    @ApiOperation(value = "删除监测点数据", notes = "根据监测点id删除数据")
    @DeleteMapping("/pointsData/delete/{id}")
    public  RcsResult deletePointData(@ApiParam(required =true, name="id", value="监测点id") @PathVariable("id") int id){
        RcsResult result= pointDataService.deleteById(id);
        return  result;
    }
    /**
     * 更新监测点数据信息
     *
     */
    @ApiOperation(value = "更新监测点数据信息", notes = "获取监测点数据记录并更新监测点数据信息")
    @ApiImplicitParam(name = "pointData", value = "pointData", required = true, dataType = "PointData")
    @PutMapping("/pointsData/update")
    public RcsResult updatePointData(@RequestBody PointData pointData){
        return      pointDataService.updatePointData(pointData);
    }

}
