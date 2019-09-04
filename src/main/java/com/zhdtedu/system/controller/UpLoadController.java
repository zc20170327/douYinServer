package com.zhdtedu.system.controller;

import com.alibaba.fastjson.JSON;
import com.zhdtedu.util.RcsResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/")
public class UpLoadController {
    private String UPLOAD_FOLDER="src/main/java/com/zhdtedu/upload/";
    @PostMapping("/upload")
    public Object singleFileUpload(MultipartFile file) {
        if (Objects.isNull(file) || file.isEmpty()) {
            return RcsResult.build(500,"文件为空，请重新上传");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            return RcsResult.build(201,"上传图像成功");
        } catch (IOException e) {
            e.printStackTrace();
           return  RcsResult.build(500,e.getMessage());
        }
    }
}
