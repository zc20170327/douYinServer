package com.zhdtedu.riverchiefs.bean;



import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;

import java.sql.Date;
@Data
@Table(name = "tb_content")
public class TbContent {



    @Column(name = "id",type = MySqlTypeConstant.BIGINT,length = 11,isKey = true,isAutoIncrement = true)
    private Long	id;
    //上级名称的id
    @Column(name = "parentId",type = MySqlTypeConstant.BIGINT,length = 11)
    private Long	parentId;
    //上级名称
    @Column(name = "parentName",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String	parentName;
    //名称
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String	name;
    //备注
    @Column(name = "description",type = MySqlTypeConstant.TEXT)
    private String	description;

    @Column(name = "create_time",type = MySqlTypeConstant.DATETIME)
    private Date createTime;

    @Column(name = "update_time",type = MySqlTypeConstant.DATETIME)
    private Date	updateTime;
    //编码
    @Column(name = "code",type = MySqlTypeConstant.INT,length = 5)
    private Integer	code;
    //是否启用 1代表启用 0代表不启用
    @Column(name = "status",type = MySqlTypeConstant.INT,length = 5)
    private Integer	status;


}
