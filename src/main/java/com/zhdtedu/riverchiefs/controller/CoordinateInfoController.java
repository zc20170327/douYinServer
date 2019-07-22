package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.RcsCoordinateInfo;
import com.zhdtedu.riverchiefs.service.CoordinateInfoService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.ReturnMsg;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class CoordinateInfoController extends  BaseController{

    @Resource
    private CoordinateInfoService coordinateInfoService;

    @ApiOperation(value="保存一条坐标信息", notes="保存一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "coordinateInfo",value = "",paramType = "form",dataType = "String")
    @ApiVersion(1)
    @PostMapping(value="/coordinate",produces = "application/json;charset=utf-8")
    public String addCoordinateInfo(@ModelAttribute RcsCoordinateInfo coordinateInfo){
        try{
            this.coordinateInfoService.add(coordinateInfo);
            return this.getReturnMsg().success("保存成功！").toJSONString();
        }catch (Exception e){
            return  this.getReturnMsg().exception(e).toJSONString();
        }
    }

    @ApiOperation(value="获取一条坐标信息", notes="获取一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "坐标ID",dataType = "int",paramType = "path")
    @ApiVersion(1)
    @GetMapping(value="/coordinate/{id}",produces = "application/json;charset=utf-8")
    public String  getCoordinateInfo(@PathVariable("id")Integer id){
        try {
            ReturnMsg msg = this.getReturnMsg();
            msg.success();
            msg.putRdata("coordinate",this.coordinateInfoService.getRcsCoordinateInfo((id)));
            return  msg.toJSONString();
        }catch (Exception e){
            return  this.getReturnMsg().exception(e).toJSONString();
        }
    }


    @ApiOperation(value="删除一条坐标信息", notes="删除一条坐标信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "坐标ID",dataType = "int",paramType = "path")
    @ApiVersion(1)
    @DeleteMapping(value="/coordinate/{id}", produces = "application/json;charset=utf-8")
    public String  delCoordinateInfo(@PathVariable("id")Integer id){
        try {
            ReturnMsg msg = this.getReturnMsg();
            this.coordinateInfoService.deleteRcsCoordinateInfo(id);
            msg.success("删除成功！");
            return  msg.toJSONString();
        }catch (Exception e){
            return  this.getReturnMsg().exception(e).toJSONString();
        }
    }
}
