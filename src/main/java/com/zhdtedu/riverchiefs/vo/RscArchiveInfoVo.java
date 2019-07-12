package com.zhdtedu.riverchiefs.vo;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
public class RscArchiveInfoVo {

    private Integer id;

    private String archNum;

    private String questionFrom;

    private String questionType;

    private String questionAddr;

    private String mapLevel;

    private String mapAddr;

    private String suosLiuy;

    private String callPhone;

    private String hdzNum;

    private String hdzRealname;

    private String hdzPhone;

    private String jbrRealname;

    private String description;

    private String report_id;

    private String reportRealname;

    private String reportDate;

    private String status;

    private String ext1;

}
