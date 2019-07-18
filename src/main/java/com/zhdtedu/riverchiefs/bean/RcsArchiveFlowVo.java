
package com.zhdtedu.riverchiefs.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "案卷代办列表")
@Data
public class RcsArchiveFlowVo implements Serializable {

    private int id;

    @ApiModelProperty(value = "案卷编号")
    private String archNum;

    @ApiModelProperty(value = "问题来源")
    private String questionFrom;

    @ApiModelProperty(value = "问题类型")
    private String questionType;

    @ApiModelProperty(value = "所属流域")
    private String suosLiuy;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "处理时间")
    private Date operTime;

    @ApiModelProperty(value = "部门名")
    private String deptName;

    public RcsArchiveFlowVo() {
    }
    public RcsArchiveFlowVo(String archNum, String questionFrom, String questionType, String suosLiuy, String status, String deptName) {
        this.archNum = archNum;
        this.questionFrom = questionFrom;
        this.questionType = questionType;
        this.suosLiuy = suosLiuy;
        this.status = status;
        this.deptName = deptName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public void setQuestionFrom(String questionFrom) {
        this.questionFrom = questionFrom;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setSuosLiuy(String suosLiuy) {
        this.suosLiuy = suosLiuy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public String getArchNum() {
        return archNum;
    }

    public String getQuestionFrom() {
        return questionFrom;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getSuosLiuy() {
        return suosLiuy;
    }

    public String getStatus() {
        return status;
    }

    public Date getOperTime() {
        return operTime;
    }

    public String getDeptName() {
        return deptName;
    }
}

