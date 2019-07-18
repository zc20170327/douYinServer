package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.service.RcsArchiveFlowService;
import com.zhdtedu.util.RcsResult;
import com.zhdtedu.util.SearchCondition;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RcsArchiveFlowController extends BaseController{
    String status = "";

    @Autowired
    private RcsArchiveFlowService  rcsArchiveFlowService;

    @ApiOperation(value="获取所有历史处理记录", notes="获取所有历史处理记录")
    @RequestMapping(value="/archive/flowList", method= RequestMethod.GET)
    public RcsResult getArchiveFlowList(){
        List<RcsArchiveFlow> rcsArchiveFlowList = rcsArchiveFlowService.getRcsArchiveFlowList();
        return RcsResult.ok(rcsArchiveFlowList);
    }

    @ApiOperation(value="插入历史记录", notes="插入历史记录")
            @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
            @ApiImplicitParams({
                    @ApiImplicitParam(name = "times",value = "时限",paramType = "query",dataType = "int"),
                    @ApiImplicitParam(name = "unit",value = "时限单位",paramType = "query",dataType = "String"),
                    @ApiImplicitParam(name = "operator",value = "处理人",paramType = "query",dataType = "String"),
                    @ApiImplicitParam(name = "operation",value = "操作",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "opinion",value = "处理意见",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptId",value = "处理部门",paramType = "query",dataType = "String")
    })
    @RequestMapping(value="/archive/flowInsert/{id}", method= RequestMethod.GET)
    public void insertArchiveFlow(@PathVariable Integer id){
        //获取请求的数据
        SearchCondition sc = this.getSearchCondition();
        //将请求的数据封装成RcsArchiveFlow对象
        RcsArchiveFlow rcsArchiveFlow = new RcsArchiveFlow(sc.getValue("operator"),
                sc.getValue("operation"),
                Integer.valueOf(sc.getValue("times")),
                sc.getValue("unit"),
                sc.getValue("deptId"));

        //根据id查询案卷登记信息
        RcsArchiveInfo rcsArchiveInfo = rcsArchiveFlowService.queryRcsArchiveInfoById(id);

        /**
         * 修改案卷登记表中的状态信息
         * 所有状态：上报，核实属实，核实不属实，验收属实，验收不属实，申请延期，已处理，申请督办，申请退回，同意退回
         */

        //获取操作信息
        String operation = sc.getValue("operation");

        //根据操作信息填写状态信息
        switch(operation)
        {
            case "申请核实":
                status = "待核实";
                break;
            case "上报" :
                status = "上报";
                break;
            case "撤回" :
                status = "上报";
                break;
            case "派遣" :
                status = "派遣中";
                break;
            case "不立案" :
                status = "不立案";
                break;
            case "申请验收" :
                status = "待验收";;
                break;
            case "结案" :
                status = "已结案";
                break;
            default :
                status = "未知状态";
        }

        //改变案卷历史记录表中的状态信息
        rcsArchiveFlow.setStatus(status);
        //插入案卷编号
        rcsArchiveFlow.setOperNum(rcsArchiveInfo.getArchNum());
        //将对象插入到历史记录表中
        rcsArchiveFlowService.insertRcsArchiveFlow(rcsArchiveFlow);
        //改变案卷登记信息表中的状态信息
        rcsArchiveInfo.setStatus(status);
        System.out.println(rcsArchiveInfo);
        rcsArchiveFlowService.modifyRcsArchiveInfo(rcsArchiveInfo);
    }
}
