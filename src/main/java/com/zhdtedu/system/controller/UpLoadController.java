package com.zhdtedu.system.controller;

import com.alibaba.fastjson.JSON;
import com.zhdtedu.system.service.PictureService;
import com.zhdtedu.util.RcsResult;
import imageHelpe.CommentTask;
import imageHelpe.FollowTask;
import imageHelpe.HightLevelTask;
import imageHelpe.LikeTask;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/picture")
public class UpLoadController {
    @Autowired
    PictureService pictureService;
    @PostMapping("/recognition")
    @ApiOperation(value = "用户图像识别", notes = "用户图像识别,支持类型评论,点赞,关注,好友任务")
    public RcsResult singleFileUpload(
            @ApiParam( name="file", value="用户图像") @RequestParam(value="file",required=true) MultipartFile file
            ,@ApiParam( name="type", value="任务类型") @RequestParam(value="type",required=true) String  type
            ,@ApiParam( name="userId", value="用户ID") @RequestParam(value="userId",required=true) int userId
            ,@ApiParam( name="amounot", value="任务积分") @RequestParam(value="amounot",required=true) int amount
    ) {
        RcsResult result = pictureService.recognition(file, type,userId,amount);
        return result;
    }
}
