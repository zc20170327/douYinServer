package com.zhdtedu.system.controller;


import com.zhdtedu.system.dao.entity.TaskType;
import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.service.TaskTypeService;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/taskType")
public class TaskTypeController {
    @Autowired
    TaskTypeService taskTypeService;

    @ApiOperation(value = "新增任务类型数据信息", notes = "新增任务类型数据信息")
    @PostMapping("/insert")
    public RcsResult insert(@RequestBody TaskType taskType) {
        RcsResult result = taskTypeService.insert(taskType);
        return result;
    }

    @ApiOperation(value = "删除任务类型数据", notes = "根据任务类型id删除数据")
    @DeleteMapping("/delete/{id}")
    public  RcsResult delete(@ApiParam(required =true, name="id", value="任务类型ID") @PathVariable("id") int id){
        RcsResult result= taskTypeService.deleteById(id);
        return  result;
    }

    @ApiOperation(value = "更新任务类型数据信息", notes = "更新任务类型数据信息")
    @PutMapping("/update")
    public RcsResult update(@RequestBody TaskType taskType){
        return      taskTypeService.update(taskType);
    }


    @ApiOperation(value = "据条件获取任务类型信息", notes = "据条件获取任务类型信息")
    @PostMapping("/get")
    public  RcsResult get(@RequestBody TaskType taskType){
        return  taskTypeService.get(taskType);
    }

}
