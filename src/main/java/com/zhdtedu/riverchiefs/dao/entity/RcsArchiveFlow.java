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
    @Column(name = "ID_",type = MySqlTypeConstant.BIGINT,length = 10,isKey = true,isAutoIncrement = true)
    private Long id;

    //案卷处理序号
    @Column(name = "OPER_NUM_",type = MySqlTypeConstant.INT,length = 10)
    private Integer operNum;

    //处理意见
    @Column(name = "OPINION_",type = MySqlTypeConstant.VARCHAR,length = 128)
    private String opinion;

    //操作
    @Column(name = "OPERATION_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String operation;

    //处理人
    @Column(name = "OPERATOR_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String operator;

    //处理时间
    @Column(name = "OPER_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date operTime;

    //时限
    @Column(name = "TIMES_",type = MySqlTypeConstant.INT,length = 10)
    private Integer times;

    //时限单位
    @Column(name = "UNIT_",type = MySqlTypeConstant.VARCHAR,length = 10)
    private String unit;

    //处理部门id
    @Column(name = "DEPT_ID_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String deptId;

    public RcsArchiveFlow() {
    }

    public RcsArchiveFlow(String operation, String operator, Integer times, String unit, String deptId) {
        this.operation = operation;
        this.operator = operator;
        this.times = times;
        this.unit = unit;
        this.deptId = deptId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOperNum(Integer operNum) {
        this.operNum = operNum;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Long getId() {
        return id;
    }

    public Integer getOperNum() {
        return operNum;
    }

    public String getOpinion() {
        return opinion;
    }

    public String getOperation() {
        return operation;
    }

    public String getOperator() {
        return operator;
    }

    public Date getOperTime() {
        return operTime;
    }

    public Integer getTimes() {
        return times;
    }

    public String getUnit() {
        return unit;
    }

    public String getDeptId() {
        return deptId;
    }
}
