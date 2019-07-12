package com.zhdtedu.riverchiefs.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name="rcs_archive_info")
public class RcsArchiveInfo {

    @Column(name="ID_",length = 11,isKey = true,type=MySqlTypeConstant.INT,isAutoIncrement =true)
    private Integer id;

    @Column(name="ARCH_NUM",type =MySqlTypeConstant.VARCHAR,length = 32)
    private String archNum;

    @Column(name="QUESTION_FROM",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String questionFrom;

    @Column(name="QUESTION_TYPE",type =MySqlTypeConstant.VARCHAR,length =20)
    private String questionType;

    @Column(name="QUESTION_ADDR",type =MySqlTypeConstant.VARCHAR,length = 128)
    private String questionAddr;

    @Column(name="MAP_LEVEL",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String mapLevel;

    @Column(name="MAP_ADDR",type =MySqlTypeConstant.VARCHAR,length = 30)
    private String mapAddr;

    @Column(name="SUOS_LIUY",type =MySqlTypeConstant.VARCHAR,length = 64)
    private String suosLiuy;

    @Column(name="CALL_PHONE",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String callPhone;

    @Column(name="HDZ_NUM",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzNum;

    @Column(name="HDZ_REALNAME",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzRealname;

    @Column(name="HDZ_PHONE",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String hdzPhone;

    @Column(name="JBR_REALNAME",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String jbrRealname;

    @Column(name="DESCRIPTION",type =MySqlTypeConstant.VARCHAR)
    private String description;

    @Column(name="REPORT_ID",type =MySqlTypeConstant.INT,length=11)
    private String report_id;

    @Column(name="REPORT_REALNAME",type =MySqlTypeConstant.VARCHAR,length = 128)
    private String reportRealname;

    @Column(name="REPORT_DATE",type =MySqlTypeConstant.DATETIME,length = 7)
    private String reportDate;

    @Column(name="STATUS_",type =MySqlTypeConstant.VARCHAR,length = 12)
    private String status;

    @Column(name="EXT1",type =MySqlTypeConstant.VARCHAR,length =50)
    private String ext1;

}
