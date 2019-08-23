package com.zhdtedu.system.service.impl;
import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.dao.entity.UserTask;
import com.zhdtedu.system.dao.mapper.TaskMapper;
import com.zhdtedu.system.dao.mapper.UserTaskMapper;
import com.zhdtedu.system.service.TaskService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    UserTaskMapper userTaskMapper;


    @Override
    public RcsResult insert(Task task) {
        try{
            taskMapper.insert(task);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            taskMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }

    @Override
    public RcsResult update(Task task) {
        try{
            taskMapper.updateById(task);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }

    @Override
    public PageModel getPages(String  pageIndex, int pageSize) {
        int counts=0;
        List<Task> taskLists=null;
        int  currentPageNo=0;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                e.printStackTrace();
            }
        }
        //获取当前条件下的总条数
        try {
            counts=taskMapper.getTotalCount();
        }catch (Exception e){
            e.printStackTrace();
        }
        //计算当前页，结束页
        PageModel pageModel=  new PageModel(currentPageNo,counts,pageSize);
        //获取当前页的数据
        try {
            taskLists= taskMapper.getLists(currentPageNo,pageSize);

        }catch (Exception e){
            e.printStackTrace();
        }
        pageModel.setList(taskLists);
        return  pageModel;
    }

    @Override
    public RcsResult doTask(int taskID, int userId) {
        UserTask userTask=new UserTask();
        userTask.setTaskId(taskID);
        userTask.setUserId(userId);
        try {
            int  count =userTaskMapper.get(userTask);
            if(count>0){
                return RcsResult.build(500,"任务已和该用户关联");
            }else{
                Task task=new Task();
                task.setId(taskID);
                //根据ID获取任务
                task=taskMapper.get(task);
                task.setQuantity(task.getQuantity()-1);
                //更新任务-1
                taskMapper.updateById(task);
                //添加和用户关联
                userTaskMapper.insert(userTask);
            }
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }


        return RcsResult.ok();
    }
}
