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
@Table(name = "sys_task")
public class Task {
    @ApiModelProperty(value = "任务id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;
    //名称
    @ApiModelProperty(value = "用户ID")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11)
    private Integer	userId;
    //电话号码
    @ApiModelProperty(value = "任务类型")
    @Column(name = "TASK_TYPE_",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	taskType;

    @ApiModelProperty(value="任务类别")
    @Column(name="TASk_CATEGORY_", type=MySqlTypeConstant.VARCHAR,length = 11)
    private String taskCategory;


    @ApiModelProperty(value = "订单时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "ORDER_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date	orderTime;



    @ApiModelProperty(value = "完成进度")
    @Column(name = "SCHEDULE_",type = MySqlTypeConstant.VARCHAR,length = 10)
    private String schedule;

    @ApiModelProperty(value = "订单金额")
    @Column(name = "ORDER_AMOUNT_",type = MySqlTypeConstant.DOUBLE,length = 15)
    private Double	orderAmount;


    @ApiModelProperty(value = "完成订单人员")
    @Column(name = "ORDER_PERSON_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String	orderPerson;

    @ApiModelProperty(value = "完成订单时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "COMPLETE_ORDER_TIME_",type = MySqlTypeConstant.DATETIME)
    private String	completeOrderTime;
    //链接，数量，描述
    @ApiModelProperty(value = "链接")
    @Column(name = "LINK_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String	link;

    //链接，数量，描述
    @ApiModelProperty(value = "数量")
    @Column(name = "QUANTITY_",type = MySqlTypeConstant.INT,length = 11)
    private Integer	quantity;

    @ApiModelProperty(value = "描述")
    @Column(name = "DESCRIPTION_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String	description;


    @ApiModelProperty(value = "积分")
    @Column(name = "INTEGRAL_",type = MySqlTypeConstant.INT,length = 111)
    private Integer	integer;



}
