package com.zhdtedu.system.dao.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@Table(name = "sys_customer_service")
public class CustomerService {
    @ApiModelProperty(value = "客服ID，自动生成")
    @Column(name = "ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer id;
    //名称
    @ApiModelProperty(value = "QQ")
    @Column(name = "QQ_",type = MySqlTypeConstant.INT,length = 11)
    private Integer	qq;
    //电话号码
    @ApiModelProperty(value = "电话")
    @Column(name = "PHONE_",type = MySqlTypeConstant.VARCHAR,length = 15)
    private String	phone;

    @ApiModelProperty(value="客服信息说明")
    @Column(name="DESCRIPTION_", type=MySqlTypeConstant.VARCHAR)
    private String description;


    @ApiModelProperty(value = "客服名称")
    @Column(name = "CUSTOMER_NAME_",type = MySqlTypeConstant.VARCHAR,length = 50)
    private String customerName;

}
