package com.zhdtedu.system.service;

import com.zhdtedu.system.dao.entity.TaskType;
import com.zhdtedu.util.RcsResult;

public interface TaskTypeService {

        RcsResult insert(TaskType taskType);

        RcsResult deleteById(int id);

        RcsResult update(TaskType taskType);

        RcsResult get(TaskType taskType);


}
