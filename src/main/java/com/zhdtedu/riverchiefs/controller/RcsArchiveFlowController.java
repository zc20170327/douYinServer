package com.zhdtedu.riverchiefs.controller;

import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.service.RcsArchiveFlowService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class RcsArchiveFlowController {

    @Autowired
    private RcsArchiveFlowService  rcsArchiveFlowService;

    @ApiOperation(value="获取所有历史处理记录", notes="获取所有历史处理记录")
    @RequestMapping(value="/archive/flowList", method= RequestMethod.GET)
    public List<RcsArchiveFlow> getArchiveFlowList(){
        return this.rcsArchiveFlowService.getRcsArchiveFlowList();
    }
}
