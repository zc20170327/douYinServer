package com.zhdtedu.riverchiefs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RcsArchiveFlowController{
    /*
    @Autowired
    private RcsArchiveFlowService  rcsArchiveFlowService;

    *//*@Autowired
    private RcsArchiveFlow rcsArchiveFlow;*//*

    *//*@Autowired
    @Setter
    private RcsArchiveInfo rcsArchiveInfo;*//*

    @Autowired
    private SearchCondition searchCondition;

    @ApiOperation(value="获取所有历史处理记录", notes="获取所有历史处理记录")
    @RequestMapping(value="/archive/flowList", method= RequestMethod.GET)
    public List<RcsArchiveFlow> getArchiveFlowList(){
        return this.rcsArchiveFlowService.getRcsArchiveFlowList();
    }

    @ApiOperation(value="插入操作处理", notes="插入操作处理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "times",value = "时限",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "unit",value = "时限单位",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "operator",value = "处理人",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "operation",value = "操作",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "opinion",value = "处理意见",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "deptId",value = "处理部门",paramType = "query",dataType = "string")
    })
    @RequestMapping(value="/archive/flowInsert", method= RequestMethod.GET)
    public void insertArchiveFlow(){
             //所有状态：上报，核实属实，核实不属实，验收属实，验收不属实，申请延期，已处理，申请督办，申请退回，同意退回
            //上报状态点击处理有以下方式
            //如果操作是 "申请核实"，状态为"待核实"
            //如果操作是"撤回"，登记，状态为"上报"
           //如果操作是"派遣"，状态为"派遣中"
           //如果操作是"不立案"，状态位"不立案"
          //如果操作是"申请验收"，状态位"待验收"
          //如果操作是"结案"，状态位"已结案"

        String status = "";
        String operation = searchCondition.getValue("operation");
        if (operation == "申请核实") {
            status = "待核实";
        } else if (operation == "撤回") {
            status = "上报";
        } else if (operation == "派遣") {
            status = "派遣中";
        } else if (operation == "不立案") {
            status = "不立案";
        } else if (operation == "申请验收") {
            status = "待验收";
        } else if (operation == "结案") {
            status = "已结案";
        } else {
            status = "未知状态";
        }


//        rcsArchiveInfo.setTimes("times");
//        rcsArchiveFlowService.insertRcsArchiveFlow(RcsArchiveFlow rcsArchiveFlow);
//        rcsArchiveFlowService.updateRcsArchiveInfoStatus(RcsArchiveInfo rcsArchiveInfo);
    }*/
}
