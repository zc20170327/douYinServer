package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.bean.RcsArchiveFlowVo;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.service.RcsArchiveFlowVoService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import com.zhdtedu.util.SearchCondition;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class RcsArchiveFlowVoController extends BaseController{
    int  currentPageNo = 0;
    int  pageSize=5;

    RcsArchiveFlowVo rcsArchiveFlowVo;

    SearchCondition sc;

    @Autowired
    private RcsArchiveFlowVoService rcsArchiveFlowVoService;

    @Autowired
    private PageModel pageModel;

    @ApiOperation(value = "获取案卷代办列表", notes = "案卷代办列表")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value = "/archive/flowVoList/{curPage}", method = RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoList(@PathVariable("curPage") String curPage) {

        if(curPage != null){
            try{
                currentPageNo = Integer.valueOf(curPage);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }

        try {
            pageModel =  rcsArchiveFlowVoService.selectRcsArchiveFlowVoList(currentPageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, e.getMessage());
        }

        return  RcsResult.ok(pageModel);
    }

    @ApiOperation(value="带条件查询案卷代办列表", notes="带条件查询案卷代办列表")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "archNum",value = "案卷编号",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionFrom",value = "来源",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "questionType",value = "类型",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "suosLiuy",value = "河段",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "deptName",value = "处置部门",paramType = "query",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/flowVoList/conditions/{curPage}", method= RequestMethod.GET)
    public RcsResult getRcsArchiveFlowVoListByCondition(@PathVariable("curPage") String curPage) {
        //获取请求的数据
        sc = this.getSearchCondition();
        //将请求的数据封装成RcsArchiveFlowVo对象
        rcsArchiveFlowVo = new RcsArchiveFlowVo(sc.getValue("archNum"),
                sc.getValue("questionFrom"),
                sc.getValue("questionType"),
                sc.getValue("suosLiuy"),
                sc.getValue("status"),
                sc.getValue("deptName"));

//        System.out.println(rcsArchiveFlowVo);
        if (curPage != null) {
            try {
                currentPageNo = Integer.valueOf(curPage);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        try {
            pageModel = rcsArchiveFlowVoService.selectRcsArchiveFlowVoByCondition(currentPageNo, pageSize,rcsArchiveFlowVo);
        } catch (Exception e) {
            e.printStackTrace();
            return RcsResult.build(500, e.getMessage());
        }

        return RcsResult.ok(pageModel);
    }
}
