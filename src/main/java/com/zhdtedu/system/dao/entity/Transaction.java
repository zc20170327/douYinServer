package com.zhdtedu.system.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@Table(name = "sys_transaction")
public class Transaction {
    @ApiModelProperty(value = "交易ID，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;
    //名称
    @ApiModelProperty(value = "交易用户ID")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11)
    private Integer	userId;
    //电话号码
    @ApiModelProperty(value = "操作员ID")
    @Column(name = "OPERATOR_ID_",type = MySqlTypeConstant.INT,length = 11)
    private Integer	operatorId;

    @ApiModelProperty(value="交易金额")
    @Column(name="AMOUNT_", type=MySqlTypeConstant.INT,length = 11)
    private Integer amount;


    @ApiModelProperty(value = "交易时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "TRANSACTION_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date transactionTime;

    @ApiModelProperty(value = "审核时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "REVIEW_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date reviewTime;

    @ApiModelProperty(value = "交易类型")
    @Column(name = "TYPE_",type = MySqlTypeConstant.VARCHAR,length = 10)
    private String type;

    @ApiModelProperty(value = "交易状态")
    @Column(name = "STATUS_",type = MySqlTypeConstant.VARCHAR,length = 15)
    private String	status;

}
