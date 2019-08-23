package com.zhdtedu.system.controller;

import com.zhdtedu.system.dao.entity.Task;
import com.zhdtedu.system.service.TaskService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/task")
public class TaskController {
    /**
     * 获取任务数据
     */
    @Autowired
    TaskService taskService;
    /**
     * 新增任务点数据信息
     */

    @ApiOperation(value = "新增任务数据信息", notes = "新增任务数据信息")
    @ApiImplicitParam(name = "task", required = true, dataType = "Task")
    @PostMapping("/insert")
    public RcsResult insert(@RequestBody Task task) {
        RcsResult result = taskService.insert(task);
        return result;
    }
    /**
     * 删除任务数据信息
     */
    @ApiOperation(value = "删除任务数据", notes = "根据任务id删除数据")
    @DeleteMapping("/delete/{id}")
    public  RcsResult delete(@ApiParam(required =true, name="id", value="任务ID") @PathVariable("id") int id){
        RcsResult result= taskService.deleteById(id);
        return  result;
    }
    /**
     * 更新任务数据信息
     *
     */
    @ApiOperation(value = "更新任务数据信息", notes = "获取任务数据记录并更新任务数据信息")
    @ApiImplicitParam(name = "task", value = "需要更新的任务数据", required = true, dataType = "Task")
    @PutMapping("/update")
    public RcsResult update(@RequestBody Task task){
        return      taskService.update(task);
    }

    /**
     * 获取任务数据列表
     */
    int  currentPageNo=0;
    int  pageSize=5;
    int totalCount=0;
    @ApiOperation(value = "获取任务数据列表", notes = "根据索引页pageIndex获取数据列表")
    @GetMapping("/tasks")
    public RcsResult getLists(
            @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=true,defaultValue="1") String pageIndex) {
        PageModel PageModel=taskService.getPages(pageIndex,5);
        return  RcsResult.ok(PageModel);
    }
    @ApiOperation(value = "做任务",notes="做任务")
    @GetMapping("/doTask")
    public  RcsResult doTask(
            @ApiParam( name="taskID", value="任务ID") @RequestParam(value="taskID",required=true,defaultValue="1") int taskID,
            @ApiParam( name="userID", value="用户ID") @RequestParam(value="userID",required=true,defaultValue="1") int userID){
        return taskService.doTask( taskID,userID);
    }


}
