package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.dao.entity.BasinInfo;
import com.zhdtedu.riverchiefs.service.BasinInfoService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin

public class BasinInfoController {

    @Autowired
    private BasinInfoService basinInfoService;
    int  currentPageNo=0;
    int  pageSize=5;
    int totalCount=0;


/**
     * 获取流域列表
     */


    @ApiOperation(value = "获取数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表")

    @GetMapping("/basins")
    public RcsResult getBasinList(@ApiParam( name="parentId", value="上级流域id") @RequestParam(value="parentId",required = false) Long parentId,
                                  @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
        List<BasinInfo> basinList=null;

        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }

        totalCount= basinInfoService.getTotalCount(parentId);

        PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);


        try {
            basinList= basinInfoService.getBasinList(parentId,currentPageNo,pageSize);
            // System.out.println("contentList"+result.get(0));

        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, e.getMessage());
        }
        pageModel.setList(basinList);

        return  RcsResult.ok(pageModel);
    }


/**
 * 新增流域信息
 */

@ApiOperation(value = "新增流域信息", notes = "新增流域信息")
@ApiImplicitParam(name = "tbBasin", value = "BasinInfo", required = true, dataType = "BasinInfo")
@PostMapping("/basins")
public RcsResult saveBasin( @RequestBody BasinInfo tbBasin) {
        RcsResult result = basinInfoService.saveBasin(tbBasin);
    return result;
}

/**
 * 通过id获取流域信息
  */

    @ApiOperation(value = "通过id获取流域信息", notes = "通过流域编码id获取流域信息")
    @GetMapping("//basins/{id}")
    public RcsResult getBasinById(@ApiParam(required =true, name="id", value="流域信息id") @PathVariable("id") Long id){
          return      basinInfoService.getBasinById(id);
    }


/**
     * 获取前端表单的数据后台更新
     * @return
     */

    @ApiOperation(value = "更新流域信息", notes = "获取修改信息对象更新")
    @ApiImplicitParam(name = "tbBasin", value = "BasinInfo", required = true, dataType = "BasinInfo")
    @PutMapping("/basins")
    public RcsResult updateBasin(@RequestBody BasinInfo tbBasin){
        return      basinInfoService.updateBasin(tbBasin);
    }


/**
     * 根据流域编码删除数据
     */


    @ApiOperation(value = "删除流域数据", notes = "根据流域id删除数据")
    @DeleteMapping("/basins/{id}")
    public RcsResult deleteContent(@ApiParam(required =true, name="id", value="流域节点id") @PathVariable("id") long id){
        RcsResult result= basinInfoService.deleteBasinById(id);
        return  result;
    }





/**
     * 获取动态树节点
     */

    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/basins/nodes")
    public RcsResult getBasinNodeList( ){
        RcsResult result= basinInfoService.getBasinNodeList();
        return  result;
    }






}


