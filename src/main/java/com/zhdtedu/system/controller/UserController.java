package com.zhdtedu.system.controller;


import com.zhdtedu.system.dao.entity.User;
import com.zhdtedu.system.service.UserService;
import com.zhdtedu.util.PageModel;
import com.zhdtedu.util.RcsResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/v1/user")
public class UserController {
    /**
     * 获取任务数据
     */
    @Autowired
    com.zhdtedu.system.service.UserService userService;
    /**
     * 新增任务点数据信息
     */

    @ApiOperation(value = "新增用户数据信息", notes = "新增用户数据信息")
    @PostMapping("/insert")
    public RcsResult insert(@RequestBody User user) {
        RcsResult result = userService.insert(user);
        return result;
    }
    /**
     * 删除用户数据信息
     */
    @ApiOperation(value = "删除用户数据", notes = "根据用户id删除数据")
    @DeleteMapping("/delete/{id}")
    public  RcsResult delete(@ApiParam(required =true, name="id", value="用户ID") @PathVariable("id") int id){
        RcsResult result= userService.deleteById(id);
        return  result;
    }
    /**
     * 更新用户数据信息
     *
     */
    @ApiOperation(value = "更新用户数据信息", notes = "获取用户数据记录并更新用户数据信息")
    @PutMapping("/update")
    public RcsResult update(@RequestBody User user){
        return      userService.update(user);
    }

    /**
     * 获取用户数据列表
     */
    int  currentPageNo=0;
    int  pageSize=5;
    int totalCount=0;
    @ApiOperation(value = "获取用户数据列表-用户后台分页查询", notes = "根据索引页pageIndex获取数据列表")
    @GetMapping("/users")
    public RcsResult getLists(
            @ApiParam( name="pageIndex", value="索引页") @RequestParam(value="pageIndex",required=true,defaultValue="1") String pageIndex) {
        PageModel PageModel=userService.getPages(pageIndex,5);
        return  RcsResult.ok(PageModel);
    }
    /**
     * 获取用户任务
     */
    @ApiOperation(value = "获取用户任务信息列表", notes = "根据用户id，获取任务信息，不传ID获取所有已被领取任务")
    @PostMapping("/userTasks")
    public  RcsResult userTasks(@RequestBody User user){
        return  userService.userTasks(user);
    }

    /**
     * 根据条件获取用户信息
     */
    @ApiOperation(value = "据条件获取用户信息", notes = "据条件获取用户信息")
    @PostMapping("/get")
    public  RcsResult get(@RequestBody User user){
        return  userService.get(user);
    }

}
