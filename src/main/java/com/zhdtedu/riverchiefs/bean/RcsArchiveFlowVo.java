
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
}

