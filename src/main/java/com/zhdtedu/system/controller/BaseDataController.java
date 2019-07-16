package com.zhdtedu.system.controller;

import com.zhdtedu.system.dao.entity.BaseData;
import com.zhdtedu.system.service.BaseDataService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础数据动态树增删改查等
 *
 */
@RestController
@Slf4j
@CrossOrigin
public class BaseDataController {
    @Autowired
    private BaseDataService baseDataService;
    int  currentPageNo=0;
    int  pageSize=5;
    int totalCount=0;

/**
 * 获取基础数据列表
 *
 *params:parentId父节点的id
 *
 *
 */

@ApiOperation(value = "获取数据列表", notes = "根据父类parentId，索引页pageIndex获取数据列表")
@GetMapping("/basedatas")
public RcsResult getBaseDataList( @ApiParam( name="parentId", value="父类id") @RequestParam(value="parentId",required = false) Long parentId,
                                 @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
    List<BaseData> baseDataList =null;
    System.out.println("pageIndex"+pageIndex);
        if(pageIndex != null){
        try{
            currentPageNo = Integer.valueOf(pageIndex);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    //System.out.println(parentId);
    totalCount= baseDataService.getTotalCount(parentId);
        //System.out.println(totalCount);
   PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);


    try {
        baseDataList = baseDataService.getBaseDataList(parentId,currentPageNo,pageSize);
        // System.out.println("baseDataList"+result.get(0));

    }catch (Exception e){
        e.printStackTrace();
        return  RcsResult.build(500, e.getMessage());
    }
    pageModel.setList(baseDataList);

    return  RcsResult.ok(pageModel);
}


    /**通过id获取基础数据的信息
     *
     *
     */
    @ApiOperation(value = "根据节点的id获取基础数据", notes = "根据节点的id获取基础数据")
    @GetMapping("/basedatas/{id}")
    public RcsResult  getBaseDatasById(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") Long id){
        BaseData baseData =new BaseData();
        try{
            baseData =   baseDataService.getBaseData(id);
        }catch(Exception e){
            return   RcsResult.build(500,e.getMessage());
        }

        return  RcsResult.ok(baseData);

    }
    /**
     * 修改基础数据保存的信息
     * 更新表单中的信息
     * @RequestBody将json数据转化为对应的实体
     */
    @ApiOperation(value = "修改基础数据后保存", notes = "根据节点id更新数据")
   // @RequestMapping(value = "/baseData/modifySave", method = RequestMethod.POST)
    @PutMapping("/basedatas")
    public  RcsResult   modifyBaseData( @RequestBody BaseData baseData){
        RcsResult result= baseDataService.updateBaseData(baseData);
        return  result;

   }
    /**
     * 删除基础数据
     * params:id
     */
    @ApiOperation(value = "删除基础数据", notes = "删除基础数据")
    @DeleteMapping("/basedatas/{id}")
    public RcsResult deleteBaseData(@ApiParam(required =true, name="id", value="节点id") @PathVariable("id") long id){
        RcsResult result= baseDataService.deleteBaseDataById(id);
        return  result;
    }

    /**
     * 新增基础数据
     * params：获取选中的parentId
     */
    @ApiOperation(value = "新增基础数据", notes = "新增基础数据")
    @ApiImplicitParam(name = "baseData", value = "BaseData", required = true, dataType = "BaseData")
    //@RequestMapping(value = "/baseData/saveBaseData", method = RequestMethod.POST)
    @PostMapping("/basedatas")
        public RcsResult saveBaseData( @RequestBody BaseData baseData){
        RcsResult result= baseDataService.saveBaseData(baseData);
        return  result;


    }
    /**
     * 获取动态树节点
     */
    @ApiOperation(value = "获取动态树", notes = "获取动态树")
    @GetMapping("/basedatas/nodes")
    public RcsResult getNodeList( ){
        RcsResult result= baseDataService.getNodeList();
        return  result;
    }




}
