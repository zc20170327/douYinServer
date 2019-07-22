package com.zhdtedu.riverchiefs.controller;

import com.sun.swing.internal.plaf.basic.resources.basic_es;
import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.dao.entity.JsonResult;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.service.RcsArchiveInfoService;
import com.zhdtedu.util.APIVersionNo;
import com.zhdtedu.util.BusinessRuntimeException;
import com.zhdtedu.util.ReturnMsg;
import com.zhdtedu.util.SearchCondition;
import io.swagger.annotations.*;
import net.bytebuddy.asm.Advice;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/{version}",name="版本号，如：v1,v2,v3")
public class RcsArchiveInfoController extends BaseController {

        @Resource
        RcsArchiveInfoService rcsArchiveInfoService;

        @ApiOperation(value="获取案卷分页信息", notes="根据分页及其它条件获取用户详细信息",produces = "application/json;charset=utf-8")
        @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
        @ApiImplicitParams({
                @ApiImplicitParam(name = "page_number",value = "第几页",paramType = "query",dataType = "int"),
                @ApiImplicitParam(name = "page_length",value = "每页数量",paramType = "query",dataType = "int"),
                @ApiImplicitParam(name = "sort",value = "排序字段",paramType = "query",dataType = "string"),
                @ApiImplicitParam(name = "order",value = "排序类型（asc,desc）",paramType = "query",dataType = "string"),
                @ApiImplicitParam(name = "search_condi",value = "查询条件",paramType = "query",dataType = "string")
        })
        @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
        @GetMapping(value = "/archive",produces = "application/json;charset=utf-8")
        public String pageQuery(){
            ReturnMsg msg = this.getReturnMsg();
            try {
                System.out.println("=========11111111======");

                SearchCondition sc = this.getSearchCondition();
                List list = rcsArchiveInfoService.pageQuery(sc);
                msg.success();
                msg.putRdata("list",list);
                msg.setPageInfo(sc);
                return  msg.toJSONString();
            }catch (Exception e){
                msg.exception(e);
                return  msg.toJSONString();
            }

        }

    @ApiOperation(value="获取案卷分页信息接口v2", notes="根据分页及其它条件获取用户详细信息v2",produces = "application/json;charset=utf-8")
    @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page_number",value = "第几页",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "page_length",value = "每页数量",paramType = "query",dataType = "int"),
            @ApiImplicitParam(name = "sort",value = "排序字段",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "order",value = "排序类型（asc,desc）",paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "search_condi",value = "查询条件",paramType = "query",dataType = "string")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_TOW)
    @GetMapping(value = "/archive",produces = "application/json;charset=utf-8")
    public String pageQuery2(){
        List list = rcsArchiveInfoService.pageQuery(this.getSearchCondition());
        Map<String,List> result = new HashMap<String,List>();
        result.put("data",list);
        System.out.println("=========222======");
        return  "{'holle':"+result+"}";
    }



    @ApiOperation(value="保存案卷信息", notes="新增或者修改案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "archive",value = "",paramType = "form",dataType = "String")
    })
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @PostMapping(value="/archive",produces = "application/json;charset=utf-8")
    public String addRcsArchiveInfo(@ModelAttribute RcsArchiveInfo archive ){
        ReturnMsg msg = this.getReturnMsg();
        try {
            if(archive.getId()==null || archive.getId().equals("")){
                this.rcsArchiveInfoService.addRcsArchiveInfo(archive,this.getSearchCondition());
            }else{
                this.rcsArchiveInfoService.modifyRcsArchiveInfo(archive,this.getSearchCondition());
            }
            msg.success("保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            msg.exception(e);
        }
        return msg.toJSONString();
    }

    @ApiOperation(value="获取一条案卷信息", notes="获取一条案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "案卷ID",dataType = "int",paramType = "path")
    @ApiVersion(APIVersionNo.VERSIONCONSTANT_ONE)
    @RequestMapping(value="/archive/{id}", method= RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getRcsArchiveInfo(@PathVariable Integer id){
        ReturnMsg msg = this.getReturnMsg();
        try {
            if(id==null || id==0){
                throw new BusinessRuntimeException("无效的ID");
            }
            RcsArchiveInfo rahi = this.rcsArchiveInfoService.getRcsArchiveInfo(id);
            msg.putRdata("archiveInfo",rahi);
            msg.success();
            return msg.toJSONString();
        }catch (Exception e){
            msg.exception(e);
        }
        return msg.toJSONString();
    }


    @ApiOperation(value="删除一条案卷信息", notes="删除一条案卷信息",produces = "application/json;charset=utf-8")
    @ApiImplicitParam(name = "id",value = "案卷ID",dataType = "int",paramType = "path")
    @RequestMapping(value="/archive/{id}", method= RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public String delRcsArchiveInfo(@PathVariable Integer id){
        ReturnMsg msg = this.getReturnMsg();
        try {
            if(id==null || id==0){
                new BusinessRuntimeException("无效的ID");
            }
            this.rcsArchiveInfoService.deleteRcsArchiveInfo(id);
            msg.success("删除成功！");
            return msg.toJSONString();
        }catch (Exception e){
            msg.exception(e);
        }
        return msg.toJSONString();
    }
}
