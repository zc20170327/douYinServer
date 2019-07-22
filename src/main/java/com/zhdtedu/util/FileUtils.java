package com.zhdtedu.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class FileUtils {

    public static String getFileType(String fileName){
        if(fileName.lastIndexOf(".")>0) {
            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
        }
        return "未知类型";
    }


    public static String  getFileSize(long length){
        DecimalFormat format = new DecimalFormat("0.00");
        return (format.format(length/1024/1024D))+"M";
    }

    public static void main(String[] args) {
        System.out.println(getFileSize(5756521L));
    }

}
