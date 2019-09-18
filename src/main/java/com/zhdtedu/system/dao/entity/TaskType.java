package com.zhdtedu.system.dao.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@Table(name = "sys_task_type")
public class TaskType {

    @ApiModelProperty(value = "任务类型id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;
    //名称
    @ApiModelProperty(value = "任务类型名")
    @Column(name = "TASK_TYPE_NAME",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String	taskTypeName;
    //积分
    @ApiModelProperty(value = "任务类型积分")
    @Column(name = "TASK_TYPE_INTEGRAL",type = MySqlTypeConstant.INT,length = 11)
    private Integer	taskTypeIntegral;











}
