package com.zhdtedu.system.service.impl;
import com.zhdtedu.system.dao.entity.TaskType;
import com.zhdtedu.system.dao.mapper.TaskTypeMapper;
import com.zhdtedu.system.service.TaskTypeService;
import com.zhdtedu.util.RcsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskTypeServiceImpl implements TaskTypeService {
    @Autowired
    TaskTypeMapper taskTypeMapper;
    @Override
    public RcsResult insert(TaskType taskType) {
        try{
            taskTypeMapper.insert(taskType);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());
        }
        return RcsResult.build(201,"新增成功",null);
    }

    @Override
    public RcsResult deleteById(int id) {
        try{
            taskTypeMapper.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            return   RcsResult.build(500,e.getMessage());
        }
        return  RcsResult.ok();
    }
    @Override
    public RcsResult update(TaskType taskType) {
        try{
            taskTypeMapper.updateById(taskType);
        }catch (Exception e){
            e.printStackTrace();
            return  RcsResult.build(500,e.getMessage());

        }
        return RcsResult.ok();

    }
    @Override
    public RcsResult get(TaskType taskType) {
        try {
            List<TaskType> taskTypes=taskTypeMapper.get(taskType);
            return RcsResult.ok(taskTypes);
        }catch (Exception e){
            return  RcsResult.build(500,e.getMessage());
        }
    }
}
