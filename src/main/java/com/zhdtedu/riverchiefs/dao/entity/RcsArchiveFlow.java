package com.zhdtedu.riverchiefs.dao.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.util.Date;

@Data
@Table(name = "rcs_archive_flow")
public class RcsArchiveFlow {
    //主键字段
    @Column(name = "F_ID",type = MySqlTypeConstant.BIGINT,length = 10,isKey = true,isAutoIncrement = true)
    private Long fId;

    //案卷处理序号
    @Column(name = "OPER_NUM",type = MySqlTypeConstant.INT,length = 10)
    private Integer operNum;

    //处理意见
    @Column(name = "OPINION",type = MySqlTypeConstant.VARCHAR,length = 128,isNull = false)
    private String opinion;

    //操作
    @Column(name = "OPERATION",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String operation;

    //处理人
    @Column(name = "OPERATOR",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String operator;

    //处理时间
    @Column(name = "OPER_TIME",type = MySqlTypeConstant.DATETIME)
    private Date operTime;

    //时限
    @Column(name = "TIMES",type = MySqlTypeConstant.INT,length = 10)
    private Integer times;

    //时限单位
    @Column(name = "UNIT",type = MySqlTypeConstant.VARCHAR,length = 10)
    private String unit;

    //处理部门
    @Column(name = "DEPT_ID",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String deptId;

}
