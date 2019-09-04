package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

public interface UserService {
        //新增监测点数据
        RcsResult insert(User user);
        //根据ID删除监测点
        RcsResult deleteById(int id);
        //根据ID更新监测点
        RcsResult update(User user);
        //根据起始页获取数据
        PageModel getPages(String pageIndex, int pageSize);
        //登录
        RcsResult  login(String name ,String  password);
        //获取用户的任务
        RcsResult userTasks(User user);



}
