package com.zhdtedu.system.dao.entity;
import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Table(name = "sys_user")
public class User {
    @ApiModelProperty(value = "用户id，自动生成")
    @Column(name = "USER_ID_",type = MySqlTypeConstant.INT,length = 11,isKey = true,isAutoIncrement = true)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    @Column(name = "USER_NAME_",type = MySqlTypeConstant.VARCHAR,length = 20)
    private String	userName;

    @ApiModelProperty(value = "手机号码")
    @Column(name = "PHONE_",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	phone;


    @ApiModelProperty(value = "密码")
    @Column(name = "PASSWORD_",type = MySqlTypeConstant.VARCHAR,length = 11)
    private String	password;


    @ApiModelProperty(value = "注册状态")
    @Column(name = "USER_STATUS_",type = MySqlTypeConstant.INT,length = 1)
    private Integer	userStatus;



    @ApiModelProperty(value = "注册时间")
    @Column(name = "SIGN_UP_TIME_",type = MySqlTypeConstant.DATETIME)
    private Date signUpTime;

    @ApiModelProperty(value = "积分")
    @Column(name = "INTEGRAL_",type = MySqlTypeConstant.INT,length = 111)
    private Integer	integral;


    @ApiModelProperty(value = "微信昵称")
    @Column(name = "WeChat_NickName_",type = MySqlTypeConstant.VARCHAR,length = 111)
    private String	wechatNickName;

   //一个用户可以有多个订单
    private List<Task> tasks;


}
