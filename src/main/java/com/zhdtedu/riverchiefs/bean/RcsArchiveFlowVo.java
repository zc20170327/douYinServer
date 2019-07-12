package com.zhdtedu.riverchiefs.bean;



import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveFlow;
import com.zhdtedu.riverchiefs.dao.entity.RcsArchiveInfo;
import com.zhdtedu.system.dao.entity.Department;

import java.io.Serializable;

public class RcsArchiveFlowVo implements Serializable {

    //案卷历史处理记录
    private RcsArchiveFlow rcsArchiveFlow;

    //案卷登记
    private RcsArchiveInfo rscArchiveInfo;

    //部门信息
    private Department department;
}
