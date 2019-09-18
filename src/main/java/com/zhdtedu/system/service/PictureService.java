package com.zhdtedu.system.service;

import com.zhdtedu.util.RcsResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    //图片识别
    RcsResult recognition(MultipartFile file, String  type, int userId, int integral);
}
