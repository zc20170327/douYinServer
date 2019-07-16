package com.zhdtedu.riverchiefs.controller;

import com.sun.swing.internal.plaf.basic.resources.basic_es;
import com.zhdtedu.riverchiefs.dao.entity.JsonResult;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.riverchiefs.service.PointDataServiceImpl;
import com.zhdtedu.riverchiefs.service.RcsArchiveInfoService;
import io.swagger.annotations.*;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class RcsArchiveInfoController  {

        @Resource
        RcsArchiveInfoService rcsArchiveInfoService;

        @ApiOperation(value="获取案卷分页信息", notes="根据分页及其它条件获取用户详细信息",produces = "application/json")
        @ApiResponses(value = {@ApiResponse(code = 405,message = "无效的",response = Integer.class)})
        @ApiImplicitParams({
                @ApiImplicitParam(name = "page_number",value = "第几页",paramType = "query",dataType = "int"),
                @ApiImplicitParam(name = "page_length",value = "每页数量",paramType = "query",dataType = "int"),
                @ApiImplicitParam(name = "sort",value = "排序字段",paramType = "query",dataType = "string"),
                @ApiImplicitParam(name = "order",value = "排序类型（asc,desc）",paramType = "query",dataType = "string"),
                @ApiImplicitParam(name = "search_condi",value = "查询条件",paramType = "query",dataType = "string")
        })
        @GetMapping(value = "/archive")
        public String pageQuery(){
          /*  List list = rcsArchiveInfoService.pageQuery(this.getSearchCondition());
            Map<String,List> result = new HashMap<String,List>();
            result.put("data",list);
            System.out.println(result.toString());
            return  result.toString();*/
          return  " ";
        }

    @ApiOperation(value="新增案卷信息", notes="新增案卷信息",produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "archive",value = "",paramType = "form",dataType = "String")
    })
    @PostMapping(value="/archive")
    public String addRcsArchiveInfo(@ModelAttribute RcsArchiveInfo archive ){
            System.out.println(archive);
            this.rcsArchiveInfoService.addRcsArchiveInfo(archive);
            return "";
    }
    @ApiOperation(value="获取一条案卷信息", notes="获取一条案卷信息")
    @ApiImplicitParam(name = "id",value = "案卷ID",dataType = "int",paramType = "path")
    @RequestMapping(value="/archive/{id}", method= RequestMethod.GET)
    public RcsArchiveInfo getRcsArchiveInfo(@PathVariable Integer id){
            return this.rcsArchiveInfoService.getRcsArchiveInfo(id);
    }


    @ApiOperation(value="删除一条案卷信息", notes="删除一条案卷信息")
    @ApiImplicitParam(name = "id",value = "案卷ID",dataType = "int",paramType = "path")
    @RequestMapping(value="/archive/{id}", method= RequestMethod.DELETE)
    public String delRcsArchiveInfo(@PathVariable Integer id){
         this.rcsArchiveInfoService.deleteRcsArchiveInfo(id);
         return  "";
    }


}
