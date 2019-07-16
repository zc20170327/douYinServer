package com.zhdtedu.riverchiefs.controller;


import com.zhdtedu.riverchiefs.service.RcsArchiveFlowVoService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RcsArchiveFlowVoController {
    int  currentPageNo = 0;
    int  pageSize=5;

    @Autowired
    private RcsArchiveFlowVoService rcsArchiveFlowVoService;

    @Autowired
    private PageModel pageModel;

    @ApiOperation(value = "获取案卷代办列表", notes = "案卷代办列表")
    @RequestMapping(value = "/archive/flowList/{curPage}", method = RequestMethod.GET)
    @ResponseBody
    public RcsResult getRcsArchiveFlowVoList(@PathVariable("curPage") String curPage) {

        if(curPage != null){
            try{
                currentPageNo = Integer.valueOf(curPage);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }

        try {
            pageModel =  rcsArchiveFlowVoService.findRcsArchiveFlowVoList(currentPageNo,pageSize);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500, e.getMessage());
        }

        return  RcsResult.ok(pageModel);
    }
}
