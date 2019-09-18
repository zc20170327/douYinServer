package com.zhdtedu.system.dao.mapper;
import com.zhdtedu.system.dao.entity.TaskType;

import java.util.List;

public interface TaskTypeMapper {
    int insert(TaskType taskType);
    int deleteById(int id);
    int updateById(TaskType taskType);
    List<TaskType> get(TaskType taskType);
}
