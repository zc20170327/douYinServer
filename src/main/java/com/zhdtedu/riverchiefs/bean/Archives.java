package com.zhdtedu.riverchiefs.bean;

import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;

@Data
@Table(name = "ri_archives")
public class Archives {

    @Column(name = "id",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer	id;

    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String	name;

    @Column(name = "description",type = MySqlTypeConstant.TEXT)
    private String	description;


}
