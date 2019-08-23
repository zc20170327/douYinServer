package com.zhdtedu.system.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Table(name = "sys_user_task")
public class UserTask {
    @ApiModelProperty(value = "用户任务关联ID")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;


    @ApiModelProperty(value = "任务ID")
    @Column(name = "TASK_ID_",type = MySqlTypeConstant.INT,length = 11)
    private Integer taskId;


    @ApiModelProperty(value = "用户ID")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11)
    private Integer userId;
}
