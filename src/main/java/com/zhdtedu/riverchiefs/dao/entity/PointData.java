package com.zhdtedu.riverchiefs.dao.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 监测数据
 */
@Data
@Table(name="rcs_point_data")
public class PointData {
    @ApiModelProperty(value = "监测数据id，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer	id;

    @ApiModelProperty(value="监测点名")
    @Column(name="NAME_" ,type=MySqlTypeConstant.VARCHAR ,length = 20)
    private String name;//监测点

    @ApiModelProperty(value="指标")
    @Column(name="QUOTA_",type=MySqlTypeConstant.VARCHAR,length = 20)
    private String quota;//指标


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "检测时间")
    @Column(name="TIME_",type=MySqlTypeConstant.DATETIME)
    private Date time;//检测时间

    @ApiModelProperty(value="检测值")
    @Column(name="MONITOR_VAULE_" ,type=MySqlTypeConstant.INT ,length = 10)
    private int monitor_value;//检测值

    @ApiModelProperty(value="标准值")
    @Column(name="STANDARD_VAlUE_" ,type=MySqlTypeConstant.INT ,length = 10)
    private int  standard_value;//标准值

    @ApiModelProperty(value="单位")
    @Column(name="UNIT_" ,type=MySqlTypeConstant.VARCHAR,length = 10)
    private String unit;//单位

    @ApiModelProperty(value="是否达标")
    @Column(name="IS_QUALIFIED_" ,type=MySqlTypeConstant.VARCHAR,length = 10)
    private String is_qualified;//是否达标

    @ApiModelProperty(value="超标倍数")
    @Column(name="MULTIPLE_" ,type=MySqlTypeConstant.INT,length = 10)
    private int multiple;//超标倍数

}
