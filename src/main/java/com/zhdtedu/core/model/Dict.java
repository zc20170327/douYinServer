package com.zhdtedu.core.model;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

@Data
@Table(name = "sys_dict")
public class Dict {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private int id;

    @Column(name = "ajbm",type = MySqlTypeConstant.VARCHAR,length = 100)
    private String ajbm;


    @Column(name = "sfwz",type = MySqlTypeConstant.VARCHAR,length = 200)
    private String sfwz;
    private String hrhm;
    private String jbrxm;
    private String jbrdh;

}
