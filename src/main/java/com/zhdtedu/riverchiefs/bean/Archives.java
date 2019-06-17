package com.zhdtedu.riverchiefs.bean;

import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;

@Data
@Table(name = "ri_archives")
public class Archives {

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
