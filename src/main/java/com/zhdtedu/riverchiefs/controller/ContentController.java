package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.bean.RcsResult;
import com.zhdtedu.riverchiefs.bean.TbContent;
import com.zhdtedu.riverchiefs.service.ContentService;
import com.zhdtedu.riverchiefs.util.PageModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ContentController {
    @Autowired
    private ContentService contentService;
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

@ApiOperation(value = "获取数据列表", notes = "获取数据列表")
@RequestMapping(value = "{}/content/list{@}", method = RequestMethod.GET)

public RcsResult getContentList(@RequestParam("parentId") long parentId,
                                @RequestParam(value="pageIndex",required=false,defaultValue="1") String pageIndex) {
    List<TbContent> contentList=null;
    //System.out.println("parentId"+parentId);

    if(pageIndex != null){
        try{
            currentPageNo = Integer.valueOf(pageIndex);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
    totalCount=contentService.getTotalCount(parentId,currentPageNo,pageSize);
   PageModel pageModel=  new PageModel(currentPageNo,totalCount,pageSize);


    try {
        contentList=contentService.getContentList(parentId,currentPageNo,pageSize);
        // System.out.println("contentList"+result.get(0));

    }catch (Exception e){
        e.printStackTrace();
        return  RcsResult.build(500, e.getMessage());
    }
    pageModel.setList(contentList);

    return  RcsResult.ok(pageModel);
}
}
