package com.zhdtedu.system.dao.mapper;

import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.RcsResult;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface UserMapper {
    int insert(User user);
    int deleteById(int id);
    int updateById(User user);
    //获取用户数据总条数
    int getTotalCount();
    //获取用户数据列表
    ArrayList<User> getLists(@Param("pageIndex")int pageIndex, @Param("pageSize")int pageSize);
    //登录
    int  login(@Param("userName") String  userName,@Param("password") String password);
    //根据条件获取用户信息
    int  get(User user);
}
