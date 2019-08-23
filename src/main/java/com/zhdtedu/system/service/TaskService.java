package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;

public interface TaskService {
        //新增监测点数据
        RcsResult insert(Task task);
        //根据ID删除监测点
        RcsResult deleteById(int id);
        //根据ID更新监测点
        RcsResult update(Task task);
        //根据起始页获取数据
        PageModel getPages(String pageIndex, int pageSize);
        RcsResult doTask(int taskID,int userId);
}
