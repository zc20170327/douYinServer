package com.zhdtedu.system.controller;

import com.zhdtedu.riverchiefs.config.ApiVersion;
import com.zhdtedu.riverchiefs.controller.BaseController;
import com.zhdtedu.system.service.SysFileInfoService;
import com.zhdtedu.util.ReturnMsg;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/{version}")
public class SysFileController extends BaseController {

    @Resource
    private SysFileInfoService sysFileInfoService;

    @ApiVersion(1)
    @RequestMapping(value="/fileUpload",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String uploadFile(HttpServletRequest request) {
        String tempId = request.getParameter("tempId");
        try {
            CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
            request.getSession().getServletContext());
            //检查form中是否有enctype="multipart/form-data"
            if(multipartResolver.isMultipart(request)) {
               //将request变成多部分request
                MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
                //获取multiRequest 中所有的文件名
                Iterator iter=multiRequest.getFileNames();
                while(iter.hasNext()) {
                    //一次遍历所有文件
                    MultipartFile mpf = multiRequest.getFile(iter.next().toString());
                    if(mpf!=null) {
                        String path = request.getSession().getServletContext().getRealPath("")+"fileupload/";
                        System.out.println("===========path========"+path+multiRequest.getParameter("keyID"));
                        System.out.println("===========type========"+mpf.getContentType());
                        System.out.println("==========name========="+mpf.getName());
                        System.out.println("==========getOriginalFilename========="+mpf.getOriginalFilename());
                        //上传
                        File mkdir = new File(path);
                        if(!mkdir.exists()){
                            mkdir.mkdir();
                        }
                        File file = new File(path+mpf.getOriginalFilename());
                        mpf.transferTo(file);
                        sysFileInfoService.uploadFile(file,request);
                    }
                }
            }
            ReturnMsg msg = this.getReturnMsg();
            msg.success();
            msg.putRdata("filelist",this.sysFileInfoService.selectByFileCode(tempId));
            return  msg.toJSONString();
        } catch (IOException e) {
            e.printStackTrace();
            return this.getReturnMsg().exception(e).toJSONString();
        }
    }

    @ApiVersion(1)
    @DeleteMapping(value="/file/{id}")
    public String deleteFileById(@PathVariable("id") int id){
        System.out.println(id);
        this.sysFileInfoService.deleteFileInfo(id);
        return this.getReturnMsg().success("删除成功！").toJSONString();
    }
}